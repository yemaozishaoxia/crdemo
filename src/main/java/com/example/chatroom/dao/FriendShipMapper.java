package com.example.chatroom.dao;

import com.example.chatroom.entity.FriendShip;
import com.example.chatroom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FriendShipMapper {

  int addFriendShip(FriendShip friendShip);

  List<FriendShip> findFriendsByUserId(Long userid);

  int deleteFriendShip(FriendShip friendShip);

  int blacklistFriendByFriendId(FriendShip friendShip);

}
