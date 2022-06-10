package com.demo.test.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.test.constant.BaseConstants;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Token
 *
 * @Author: cwt
 */
public class TokenUtils {

    private static final long EXPIRE_DATE = 30 * 60 * 100000;   //过期时间

    private static final String TOKEN_SECRET = BaseConstants.TOKEN_SECRET;

    private final static long EXPIRE_TIME = BaseConstants.TOKEN_EXPIRE * 60;

    protected static final long MILLIS_SECOND = 1000;

    /**
     * 生成token
     *
     * @param uid
     * @param username
     * @param password
     * @return
     */
    public static String genToken(String uid, String username, String password) {

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("user_id", uid)
                    .withClaim("username", username)
                    .withClaim("password", password).withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Map<String, String> parseToken(String token) {
        DecodedJWT decode = JWT.decode(token);
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", decode.getClaim("user_id").asString());
        map.put("username", decode.getClaim("username").asString());
        return map;
    }

}
