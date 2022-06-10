package com.demo.test.common.web;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应体
 *
 * @Author: cwt
 */
@Data
@NoArgsConstructor
public class WebResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private long code;

    /** 返回消息内容 */
    private String msg;

    /** 数据对象 */
    private T data;

    public WebResponse(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> success() {
        return new WebResponse<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> WebResponse<T> success(T data) {
        return new WebResponse<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> WebResponse<T> success(T data, String message) {
        return new WebResponse<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> WebResponse<T> failed(IErrorCode errorCode) {
        return new WebResponse<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> WebResponse<T> failed(IErrorCode errorCode,String message) {
        return new WebResponse<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> WebResponse<T> failed(String message) {
        return new WebResponse<T>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> WebResponse<T> failed() {
        return failed(ResultCodeEnum.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> WebResponse<T> validateFailed() {
        return failed(ResultCodeEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> WebResponse<T> validateFailed(String message) {
        return new WebResponse<T>(ResultCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> WebResponse<T> unauthorized(T data) {
        return new WebResponse<T>(ResultCodeEnum.UNAUTHORIZED.getCode(), ResultCodeEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> WebResponse<T> forbidden(T data) {
        return new WebResponse<T>(ResultCodeEnum.FORBIDDEN.getCode(), ResultCodeEnum.FORBIDDEN.getMessage(), data);
    }
}
