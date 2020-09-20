package com.example.chatroom.enums;

public enum ApiMsgEnum {
    /** 参数异常 */
    AuthenticationNull_EXCEPTION("101", "Authentication为空!"),
    AuthenticationNotCorrect_EXCEPTION("102", "Authentication不正确!"),
    UserNotExist_EXCEPTION("103", "用户不存在"),
    AuthenticationOverTime_EXCEPTION("104", "Authentication超时!");
    /**
     * 消息码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    ApiMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
