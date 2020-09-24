package com.example.chatroom.entity;

public class FriendShip {
  private Long id;

  private Long friendid;

  private Long userid;

  private String friendname;

  public FriendShip() {
  }

  public FriendShip(Long id, Long friendid, Long userid, String friendname) {
    this.id = id;
    this.friendid = friendid;
    this.userid = userid;
    this.friendname = friendname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFriendid() {
    return friendid;
  }

  public void setFriendid(Long friendid) {
    this.friendid = friendid;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public String getFriendname() {
    return friendname;
  }

  public void setFriendname(String friendname) {
    this.friendname = friendname;
  }
}
