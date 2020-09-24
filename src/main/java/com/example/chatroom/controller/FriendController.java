package com.example.chatroom.controller;

import com.example.chatroom.annotation.UnInterception;
import com.example.chatroom.entity.User;
import com.example.chatroom.enums.ApiMsgEnum;
import com.example.chatroom.exception.Api403Exception;
import com.example.chatroom.resp.JsonResult;
import com.example.chatroom.service.FriendShipService;
import com.example.chatroom.service.UserService;
import com.example.chatroom.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/friend")
public class FriendController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(FriendController.class);
  @Autowired private FriendShipService friendShipService;

  @Autowired private UserService userService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @UnInterception
  public ResponseEntity addFriend(String userid) {
    String usid = userid.trim();
    if (usid.equals("")) {
      throw new Api403Exception(ApiMsgEnum.PARAMNULL_EXCEPTION);
    }
    Long id = Long.valueOf(usid);
    String token = request.getHeader("Authorization");
    String username = JwtUtil.getParam("username", token);
    User user = userService.findUserByUsername(username);
    if (id.equals(user.getId())) {
        throw new Api403Exception(ApiMsgEnum.NOTALLOWEDADDSELF_EXCEPTION);
    }
//    插入发送好友添加请求
    return new ResponseEntity(new JsonResult("123", "可以进行添加"), HttpStatus.OK);
  }

    @RequestMapping(value = "/agreeadd", method = RequestMethod.POST)
    @UnInterception
    public ResponseEntity agreeAdd(String userid) {
//   接收好友请求 接收请求者id 包装friendship 双向添加
        return new ResponseEntity(new JsonResult("123", "可以进行添加"), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @UnInterception
    public ResponseEntity deleteFriend(String userid) {
//   单方面删除好友
        return new ResponseEntity(new JsonResult("123", "可以进行添加"), HttpStatus.OK);
    }

    @RequestMapping(value = "/black", method = RequestMethod.DELETE)
    @UnInterception
    public ResponseEntity blackFriend(String userid) {
//     双方面方面删除好友
        return new ResponseEntity(new JsonResult("123", "可以进行添加"), HttpStatus.OK);
    }
}
