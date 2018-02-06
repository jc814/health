package utils;

import hzy.dto.AdminDTO;
import io.jsonwebtoken.*;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jjwt工具类
 *
 * @author hzy
 * @date 2018/01/28
 */
public class JwtUtils {
    /**
     * 保存时长（毫秒）
     */
    private final static long  KEEP_TIME = 1800000;

    /**
     * 秘钥
     */
    private final static String  SECRET_KEY = "worromoTretteb";
    /**
     * 创建token
     * @return
     */
    public static String createToken(String id, AdminDTO admin){
        long ttlMillis = KEEP_TIME;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .claim("id", admin.getId())
                .claim("hid", admin.getHid())
                .claim("name", admin.getName())
                .claim("type", admin.getType())
                .claim("time", admin.getLastTime())
                .claim("nameForToken", admin.getNameForToken())
                .claim("photo", admin.getPhoto());
        builder.signWith(signatureAlgorithm, signingKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 验证token
     * @return
     */
    public static Result verifyToken(String token){
        Result result = null;
        if(token == null || "".equals(token)){
            //没有token信息
            result = new Result(false, 6001);
        }else{
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                        .parseClaimsJws(token).getBody();
                Integer id = (Integer) claims.get("id");
                Short type = (Short) claims.get("type");
                String name = claims.get("name").toString();
                String md5 = createMd5(encrypt(id, name, type));
                if(md5 != null && md5.equals(claims.get("nameForToken"))){
                    result = new Result(true);
                }else{  //被篡改过
                    result = new Result(false, 6002);
                }
            } catch (ExpiredJwtException e){ //过期token
                result = new Result(false, 6003);

            } catch (SignatureException | MalformedJwtException e) { //非法token
                result = new Result(false, 6002);
            }
        }

        return result;
    }
    /**
     * 解析token
     * @return
     */
    public static Map<String,Integer> verifyAuth(String token) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(token).getBody();
            Integer id = (Integer) claims.get("id");
            Integer type = (Integer) claims.get("type");
            Integer hid = (Integer) claims.get("hid");
            result.put("id", id);
            result.put("type", type);
            result.put("hid", hid);
        } catch (ExpiredJwtException e) { //过期token
            e.printStackTrace();

        } catch (SignatureException | MalformedJwtException e) { //非法token
            e.printStackTrace();
        }
        return result;
    }

    /**
     * md5算法
     * @return
     */
    public static String createMd5(String code){
        try{
            // 获得一个指定编码的信息摘要算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            // 获得数据的数据指纹
            String digest = base64en.encode(md.digest(code.getBytes()));
            return digest;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 登录加密算法
     * @return
     */
    public static String encrypt(Integer id, String name, Short type){
        int length = name.length();
        int position = id % length;
        String pre = name.substring(0,position);
        String sub = name.substring(position+1 , length);
        String newName = pre + id + "61" + type + "23" + sub;
        return  newName;
    }
}
