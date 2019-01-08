package com.example.service.sys;

import com.example.pojo.sys.Permission;

import java.util.List;

/**
 * ClassName: PermissionServer
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2018/12/14下午 1:53
 * Version: 1.0
 */
public interface PermissionService {
    List<Permission> getPerssionByRoleId(Integer parentId, Integer roleId);
}
