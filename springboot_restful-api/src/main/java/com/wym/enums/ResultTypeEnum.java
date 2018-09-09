package com.wym.enums;

/**
 * 响应类型
 * @author yongmao.wu
 *
 */
public enum ResultTypeEnum {
    SUCCESS {
        public int getCode() {
            return 0;
        }

        public String getMessage() {
            return "操作成功";
        }
    },
    FAIL {
        public int getCode() {
            return 1;
        }
    },
    OTHER {
        public int getCode() {
            return 2;
        }
    };

    public abstract int getCode();

    public String getMessage() {
        return "";
    }
}