package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.sys.Permission;
import com.example.pojo.sys.UserRole;
import com.example.service.sys.PermissionService;
import com.example.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/index")
    public String index(HttpSession session, HttpServletRequest request){
        Object userId = session.getAttribute("userId");
        if(userId!=null){
            //获取该角色下的权限一级菜单
            List<Permission> perssionByRoleList = permissionService.getPerssionByRoleId(0, (Integer) session.getAttribute("roleId"));
            request.setAttribute("perssionByRoleList",perssionByRoleList);
        }
        return "index";
    }
    @RequestMapping("/getMenu")
    @ResponseBody
    public JSONObject menu(String parentId, HttpSession session, HttpServletRequest request){
        System.out.println(parentId);
        JSONObject json = new JSONObject();
        //获取该角色下的权限一级菜单
        List<Permission> getPerssionByRole = permissionService.getPerssionByRoleId(Integer.valueOf(parentId), (Integer) session.getAttribute("roleId"));
        json.put("getPerssionByRole",getPerssionByRole);
        return  json;
    }
   /* @RequestMapping("/userList")
    public String userList(){
        return "userList";
    }
    @RequestMapping("/getUserListPage")
    @ResponseBody
    public PageHelper<User> getUserListPage(User user, HttpServletRequest request){
        PageHelper<User> pageHelper = new PageHelper<User>();
        // 统计总记录数
        Integer total = userService.getCount(user);
        pageHelper.setTotal(total);

        // 查询当前页实体对象
        List<User> list = userService.getList(user);
        pageHelper.setRows(list);

        return pageHelper;
    }*/
}
