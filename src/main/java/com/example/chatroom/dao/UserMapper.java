package com.example.chatroom.dao;

import java.util.List;

import com.example.chatroom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.chatroom.entity.UserExample;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
  long countByExample(UserExample example);

  int deleteByExample(UserExample example);

  int deleteByPrimaryKey(Long id);

  int insert(User record);

  int insertSelective(User record);

  List<User> selectByExample(UserExample example);

  User selectByPrimaryKey(Long id);

  User selectByUsername(String username);

  int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

  int updateByExample(@Param("record") User record, @Param("example") UserExample example);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}
