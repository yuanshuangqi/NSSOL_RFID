package com.nssol.web.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.nssol.web.common.entity.Payload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {
    private static final String JWT_PAYLOAD_USER_KEY = "com.nssol.web.user";
    public static String generateTokenExpireInMinutes(Object userInfo, PrivateKey privateKey,int expire){
        return Jwts.builder()
                .claim(JWT_PAYLOAD_USER_KEY, JSONUtil.parse(userInfo).toString())
                .setId(createJTI())
                .setExpiration(DateUtil.offsetMinute(new Date(),expire))
                .signWith(privateKey)
                .compact();
    }
    /**
     * 公钥解析token
     */
    private static Jws<Claims> parserToken(String token, PublicKey publicKey){
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }
    private static String createJTI(){
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }
    /**
     * 获取token中的载荷信息
     */
    public static <T>Payload<T> getInfoFromToken(String token, PublicKey publicKey, Class<T> userType){
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setUserInfo(JSONUtil.toBean(body.get(JWT_PAYLOAD_USER_KEY).toString(),userType));
        claims.setExpiration(body.getExpiration());
        return  claims;
    }
    /**
     * 获取token中的载荷信息
     */
    public static <T>Payload<T> getInfoFromToken(String token,PublicKey publicKey){
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setExpiration(body.getExpiration());
        return  claims;
    }
}
