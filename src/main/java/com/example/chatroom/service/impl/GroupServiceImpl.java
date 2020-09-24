package com.example.chatroom.service.impl;

import com.example.chatroom.dao.GroupMapper;
import com.example.chatroom.entity.Groups;
import com.example.chatroom.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Groups findGroupById(Long id) {
        return groupMapper.findGroupById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Groups findGroupByGroupName(String groupName) {
        return groupMapper.findGroupByGroupName(groupName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Groups> findGroupsByCreatorId(Long creatorId) {
        return groupMapper.findGroupsByCreatorId(creatorId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertGroups(Groups groups) {
        return groupMapper.insertGroups(groups);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateGroupsName(Groups groups) {
        return groupMapper.updateGroupsName(groups);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteGroupsById(Long id) {
        return groupMapper.deleteGroupsById(id);
    }
}
