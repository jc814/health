package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

/**时
 * jjwt工具类
 *
 * @author hzy
 * @date 2018/01/27
 */
public class JwtUtil {
    /**
     *
     * @param subject
     * @return
     */
    public static String createToken(String subject){
        Key key = MacProvider.generateKey();
        //产生令牌
        String token = Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return "";
    }

    public static Claims verifyToken(String token){
        return  null;
    }
}
