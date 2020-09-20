package com.example.chatroom;

import com.example.chatroom.entity.User;
import com.example.chatroom.service.UserService;
import com.example.chatroom.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatroomApplicationTests {
  @Autowired
  UserService userService;

  @Test
  void contextLoads() {}

  @Test
  void test01() {
    String s = new String("Basic   123");
    String a = s.replaceAll(" ", "");
    String b = a.replace("Basic", "");
    System.out.println(b);
  }

  @Test
  void test02() {
    User user = new User();
    user.setUsername("sunliang");
    user.setPassword("sunliang");
    String s = JwtUtil.createJWT(100000000, user);
    System.out.println(s);
  }

  @Test
  void test03() {
    User user=userService.findUserByUsername("sunliang");
    System.out.println(user.getId());
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());
    System.out.println(user.getEmail());
  }
  @Test
  void test04() {


  }
}
