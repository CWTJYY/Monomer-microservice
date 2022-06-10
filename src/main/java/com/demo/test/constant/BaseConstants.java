package com.demo.test.constant;

/**
 * 通用基本常量
 */
public interface BaseConstants {
    /** UTF-8 字符集 **/
    String UTF8 = "UTF-8";

    /** GBK 字符集 **/
    String GBK = "GBK";

    /**
     * http请求
     */
    String HTTP = "http://";

    /**
     * https请求
     */
    String HTTPS = "https://";

    /**
     * 验证码有效期（分钟）
     */
    long CAPTCHA_EXPIRATION = 60;

    /**
     * 令牌有效期（分钟）
     */
    long TOKEN_EXPIRE = 720;

    /**
     * token秘钥
     */
    String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
}
