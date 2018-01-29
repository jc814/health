package utils;

import hzy.dto.AdminDTO;
import io.jsonwebtoken.*;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;

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
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(token).getBody();
            Integer id = (Integer) claims.get("id");
            String name = claims.get("name").toString();
            String md5 = createMd5(encrypt(id, name));
            if(md5 != null && md5.equals(claims.get("nameForToken"))){
                result = new Result(true);
            }else{
                result = new Result(false, 603);
            }
        } catch (ExpiredJwtException e){ //过期token
            result = new Result(false, 601);

        } catch (SignatureException | MalformedJwtException e) { //非法token
            result = new Result(false, 602);
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
    public static String encrypt(Integer id ,String name){
        int length = name.length();
        int position = id % length;
        String pre = name.substring(0,position);
        String sub = name.substring(position+1 , length);
        String newName = pre + id + "623" + sub;
        return  newName;
    }
}
