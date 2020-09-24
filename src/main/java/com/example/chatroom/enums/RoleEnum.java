package com.example.chatroom.enums;


public enum RoleEnum {

    ROLE_USER(1,"ROLE_USER"),

    ROLE_MODERATOR(2,"ROLE_MODERATOR"),

    ROLE_ADMIN(3,"ROLE_ADMIN");

    private Integer roleid;

    private String rolename;

    RoleEnum(Integer roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
