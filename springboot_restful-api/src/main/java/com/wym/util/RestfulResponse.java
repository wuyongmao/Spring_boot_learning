package com.wym.util;

/**
 * 返回信息封装
 * @author yongmao.wu
 *
 */
public class RestfulResponse {
    /**
     * 业务操作结果Code
     */
    protected int code;
    /**
     * 消息
     */
    protected String message;
    public RestfulResponse() {
    }

    public RestfulResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
