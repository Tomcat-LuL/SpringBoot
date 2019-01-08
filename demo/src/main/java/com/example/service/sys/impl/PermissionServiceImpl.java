package com.example.service.sys.impl;

import com.example.mapper.sys.PermissionMapper;
import com.example.pojo.sys.Permission;
import com.example.service.sys.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: PermissionServiceImpl
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2018/12/14下午 1:54
 * Version: 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPerssionByRoleId(Integer parentId, Integer roleId) {
        return permissionMapper.getPerssionByRoleId(parentId,roleId);
    }
}
