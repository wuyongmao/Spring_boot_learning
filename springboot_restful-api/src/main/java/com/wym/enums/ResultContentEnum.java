package com.wym.enums;

/**
 * 调用接口返回内容枚举类
 * @author yongmao.wu
 *
 */
public enum ResultContentEnum {

    RESULT_CODE {
        public String getName() {
            return "code";
        }
    },
    RESULT_MESSAGE {
        public String getName() {
            return "message";
        }
    },
    RESULT_DATA{
        public String getName() {
            return "data";
        }
    };

    public abstract String getName();

}
