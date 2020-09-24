package com.example.chatroom.entity;

import com.example.chatroom.enums.RightEnum;
import com.example.chatroom.enums.RoleEnum;

public class Role {

  private Integer id;

  private String rolename;

  public Role(RoleEnum roleEnum) {
    this.id=roleEnum.getRoleid();
    this.rolename=roleEnum.getRolename();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }
}
