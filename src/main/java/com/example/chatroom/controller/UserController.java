package com.example.chatroom.controller;

import com.example.chatroom.annotation.UnInterception;
import com.example.chatroom.entity.User;
import com.example.chatroom.enums.ApiMsgEnum;
import com.example.chatroom.exception.Api401Exception;
import com.example.chatroom.exception.Api403Exception;
import com.example.chatroom.resp.JsonResult;
import com.example.chatroom.resp.JwtResp;
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

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController extends BaseController{
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
  @UnInterception
  public ResponseEntity register(@Valid User user) {
    User returnedUser = userService.findUserByEmail(user.getEmail());
    if (returnedUser != null) {
      logger.info(user.getEmail() + "邮箱已被注册");
      return new ResponseEntity(new JsonResult<>("1", "邮箱已被注册"), HttpStatus.UNAUTHORIZED);
    }
    returnedUser = userService.findUserByUsername(user.getUsername());
    if (returnedUser != null) {
      logger.info(user.getUsername() + "用户名已被注册");
      return new ResponseEntity(new JsonResult<>("1", "用户名已被注册"), HttpStatus.UNAUTHORIZED);
    }
    int rows=userService.addUser(user);
    if (rows<1){
      logger.info(user.getUsername() + "用户注册失败");
      throw new Api403Exception(ApiMsgEnum.DATABASE_EXCEPTION);
    }else
    logger.info(user.getUsername() + "用户注册成功");
    return new ResponseEntity(new JsonResult<>("0", "用户注册成功"), HttpStatus.OK);
  }

  @UnInterception
  @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
  public ResponseEntity login(@Valid User user) {
    User returnUser = userService.findUserByUser(user);
    if (returnUser == null) {
      logger.info(user.getUsername() + "密码错误，登陆失败");
      throw new Api401Exception(ApiMsgEnum.PASSWORDNOTCORRECT_EXCEPTION);
    } else {
      logger.info(returnUser.getUsername() + "用户登陆成功");
      // 设置1天的token过期时间
      String token = JwtUtil.createJWT(user);
      logger.info(user.getUsername() + "的token为：" + token);
      return new ResponseEntity(
          new JsonResult(
              "0",
              new JwtResp(
                  token, returnUser.getId(), returnUser.getUsername(), returnUser.getEmail()),
              returnUser.getUsername() + "用户登陆成功"),
          HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  public ResponseEntity hi() {
    return new ResponseEntity(new JsonResult("0", "HI"), HttpStatus.OK);
  }
}
