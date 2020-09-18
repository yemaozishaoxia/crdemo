package org.chatroom.crdemo.controller;

import org.apache.ibatis.annotations.Param;
import org.chatroom.crdemo.annotation.UnInterception;
import org.chatroom.crdemo.entity.User;
import org.chatroom.crdemo.pojo.JsonResult;
import org.chatroom.crdemo.service.UserService;
import org.chatroom.crdemo.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    @UnInterception
    public JsonResult register(@Valid User user) {
        User return_user=userService.findUserByEmail(user);
        if (return_user!=null){
            logger.info(user.getEmail()+"邮箱已被注册");
            return new JsonResult("1","邮箱已被注册");
        }
        return_user=userService.findUserByUsername(user.getUsername());
        if (return_user!=null){
            logger.info(user.getUsername()+"用户名已被注册");
            return new JsonResult("1","用户名已被注册");
        }
        userService.addUser(user);
        logger.info(user.getUsername()+"用户注册成功");
        return new JsonResult("0","用户注册成功");
    }
    @UnInterception
    @RequestMapping(value = "/sign-up",method = RequestMethod.POST)
    public JsonResult login(@Valid User user) {
        User returnUser=userService.findUserByUser(user);
        if (returnUser==null){
            logger.info(user.getUsername()+"密码错误，登陆失败");
            return new JsonResult("1",user.getUsername()+"密码错误，登陆失败");
        }else {
            logger.info(returnUser.getUsername()+"用户登陆成功");
            //设置1天的token过期时间
            String token=JwtUtil.createJWT(86400000,user);
            Map<String,String> map=new HashMap<>();
            map.put("Authorization",token);
            return new JsonResult("0",map,returnUser.getUsername()+"用户登陆成功");
        }
    }
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public JsonResult hi(){
        return new JsonResult("0","hi");
    }
}
