package com.mao.util;

import com.auth0.jwt.JWT;
//import com.mao.util.property.JWTProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "mao.jwt")
public class JwtUtils {

    private String secret;      //秘钥
    private long expire;        //token有效时长，7天，单位 秒
    private String header;      //Authorization

//    //获取token时，获取jwt配置信息，
//    @Autowired
//    private JWTProperty jwtProperty ;
//    //签名
//    @Value("${jwt.sing}")
//    private String sing ;
//    private static ThreadLocal<Object> requestUserThreadLocal = new ThreadLocal<>();

    /**
     * 生成jwt token
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 校验jwt
     * */
    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("validate is token error ", e);
            return null;
        }
    }

//    //将token存储在当前线程
//    public  void setThreadLocalToken(String token) {
//        requestUserThreadLocal.set(token);
//    }
//    //从当前线程中获取token
//    public  String getThreadLocalToken() {
//        return requestUserThreadLocal.get().toString();
//    }
//    //获取DecodedJWT（解码后的token）
//    public  DecodedJWT getThreadLocalDecodedJWT() {
//        String token = getThreadLocalToken();
//        System.out.println("======");
//        System.out.println("token="+token);
//        System.out.println(this.sing);
//        return JWT.require(Algorithm.HMAC256(jwtProperty.getSing())).build().verify(token);
//    }
//    //清空
//    public  void removeThreadLocal() {
//        requestUserThreadLocal.remove();
//    }
//
//    //获取当前登录的是游客还是博主：type（0：游客，1：博主）
//    public  Integer getThreadLocalType() {
//        DecodedJWT verify = getThreadLocalDecodedJWT();
//        Integer type = Integer.parseInt(verify.getClaim("type").asString());
//        log.info("【type="+type+"】");
//        return type;
//    }
//    //获取当前登录对象id
//    public  Long getThreadLocalUserId(){
//        DecodedJWT verify = getThreadLocalDecodedJWT();
//        Integer type = getThreadLocalType();
//        Long userId = null;
//        if(type==0){
//            userId  = Long.parseLong(verify.getClaim("visitorId").asString());
//        }else if(type==1){
//            userId  = Long.parseLong(verify.getClaim("bloggerId").asString());
//        }
//        return userId;
//    }


    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
