package com.example.chatroom.dao;


import com.example.chatroom.entity.Groups;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface GroupMapper {

    Groups findGroupById(Long id);

    Groups findGroupByGroupName(String groupName);

    List<Groups> findGroupsByCreatorId(Long creatorId);

    int insertGroups(Groups groups);

    int updateGroupsName(Groups groups);

    int deleteGroupsById(Long id);
}
