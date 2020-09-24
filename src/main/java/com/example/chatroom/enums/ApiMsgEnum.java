package com.example.chatroom.enums;

public enum ApiMsgEnum {
    /** 参数异常 */
    AUTHENTICATIONNULL_EXCEPTION("101", "Authentication为空!"),
    AUTHENTICATIONNOTCORRECT_EXCEPTION("102", "Authentication不正确!"),
    USERNOTEXIST_EXCEPTION("103", "用户不存在"),
    PASSWORDNOTCORRECT_EXCEPTION("104", "密码错误"),
    AUTHENTICATIONOVERTIME_EXCEPTION("105", "Authentication超时或不包含参数!"),
    JWTEXPIRETIMENOTCORRECT_EXCEPTION("106","Jwt过期时间不正确！"),
    DATABASE_EXCEPTION("107","数据库异常，操作失败！"),
    PARAMNULL_EXCEPTION("108", "参数为空"),
    NOTALLOWEDADDSELF_EXCEPTION("109", "不能添加自己");
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
