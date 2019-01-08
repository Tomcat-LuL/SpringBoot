package com.example.mapper.sys;


import com.example.pojo.sys.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    /**根据角色Id查询所拥有的权限*/
    List<Permission> getPerssionByRoleId(@Param("parentId") Integer parentId, @Param("roleId") Integer roleId);
}