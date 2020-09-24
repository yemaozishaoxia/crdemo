package com.example.chatroom.service;

import com.example.chatroom.entity.Groups;

import java.util.List;

public interface GroupService {
    Groups findGroupById(Long id);

    Groups findGroupByGroupName(String groupName);

    List<Groups> findGroupsByCreatorId(Long creatorId);

    int insertGroups(Groups groups);

    int updateGroupsName(Groups groups);

    int deleteGroupsById(Long id);
}
