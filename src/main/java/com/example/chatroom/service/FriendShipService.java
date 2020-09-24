package com.example.chatroom.service;

import com.example.chatroom.entity.Friend;
import com.example.chatroom.entity.FriendShip;

import java.util.List;

public interface FriendShipService {

    int addFriendShip(FriendShip friendShip);

    List<FriendShip> findFriendsByUserId(Long userid);

    int deleteFriendShip(FriendShip friendShip);

    int blacklistFriendByFriendId(FriendShip friendShip);
}
