package com.wym.enums;

/**
 * 自定义响应状态码
 * @author yongmao.wu
 *
 */
public enum SelfHttpStatus {
    PARAMS_IS_NULL(10001,"Parameter is null"),
    PARAMS_NOT_COMPLETE(10004,"Parameter is invalid")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    SelfHttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
