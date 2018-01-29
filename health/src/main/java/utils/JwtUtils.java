package utils;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
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
    public static String createToken(String id, String issuer, String subject){
        long ttlMillis = KEEP_TIME;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now);
        if(subject!=null){
            builder.setSubject(subject);
        }
        if(issuer!=null){
            builder.setIssuer(issuer);
        }
        builder .signWith(signatureAlgorithm, signingKey);

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
        Result result = new Result();
        try {

        } catch (SignatureException | MalformedJwtException e) { //非法token

        } catch (ExpiredJwtException e){ //过期token

        }
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token).getBody();
        return result;
    }
}
