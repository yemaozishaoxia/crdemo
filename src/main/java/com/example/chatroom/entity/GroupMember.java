package com.example.chatroom.entity;

import com.example.chatroom.enums.RoleEnum;

public class GroupMember {

    private Long  id;

    private Long userid;

    private Integer roleid;

    public GroupMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getRightid() {
        return roleid;
    }

    public void setRightid(Integer roleid) {
        this.roleid = roleid;
    }
}
