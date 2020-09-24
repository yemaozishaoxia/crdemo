package com.example.chatroom.service.impl;

import com.example.chatroom.dao.FriendShipMapper;
import com.example.chatroom.entity.FriendShip;
import com.example.chatroom.enums.ApiMsgEnum;
import com.example.chatroom.exception.Api403Exception;
import com.example.chatroom.service.FriendShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FriendShipServiceImpl implements FriendShipService {
  @Autowired FriendShipMapper friendShipMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int addFriendShip(FriendShip friendShip) {
    int rows = 0;
    try {
      rows = friendShipMapper.addFriendShip(friendShip);
    } catch (Exception e) {
      throw new Api403Exception(ApiMsgEnum.DATABASE_EXCEPTION);
    }
    return rows;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public List<FriendShip> findFriendsByUserId(Long userid) {
    List<FriendShip> lists;
    lists=friendShipMapper.findFriendsByUserId(userid);
    return lists;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int deleteFriendShip(FriendShip friendShip) {
    int rows = 0;
    try {
      rows = friendShipMapper.deleteFriendShip(friendShip);
    } catch (Exception e) {
      throw new  Api403Exception(ApiMsgEnum.DATABASE_EXCEPTION);
    }
    return rows;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int blacklistFriendByFriendId(FriendShip friendShip) {
    int rows = 0;
    try {
      rows = friendShipMapper.blacklistFriendByFriendId(friendShip);
    } catch (Exception e) {
      throw new  Api403Exception(ApiMsgEnum.DATABASE_EXCEPTION);
    }
    return rows;
  }
}
