package com.example.chatroom.entity;


import com.example.chatroom.enums.RightEnum;

public class Rights {

    private Integer id;

    private String rightname;

    public Rights(RightEnum rightEnum) {
        this.id=rightEnum.getRightid();
        this.rightname=rightEnum.getRightname();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname;
    }
}
