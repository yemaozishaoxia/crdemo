package com.example.chatroom.enums;

public enum RightEnum {

    RIGHT_USER(1,"RIGHT_USER"),

    RIGHT_MODERATOR(2,"RIGHT_MODERATOR"),

    RIGHT_ADMIN(3,"RIGHT_ADMIN");

    private Integer rightid;

    private String rightname;

    RightEnum(Integer rightid, String rightname) {
        this.rightid = rightid;
        this.rightname = rightname;
    }

    public Integer getRightid() {
        return rightid;
    }

    public void setRightid(Integer rightid) {
        this.rightid = rightid;
    }

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname;
    }
}
