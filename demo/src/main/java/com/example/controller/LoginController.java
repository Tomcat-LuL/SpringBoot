package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.sys.User;
import com.example.pojo.sys.UserRole;
import com.example.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request,String username,String password){
        JSONObject jsonObject = new JSONObject();
        if(username!=null && password !=null){
            User user = userService.findUserByName(username, password);
            if(user!=null){
                //获取该用户的角色
                UserRole userRoleById = userService.getUserRoleById(user.getId());
                request.getSession().setAttribute("roleId",userRoleById.getUserRoleId());
                request.getSession().setAttribute("userRoleName",userRoleById.getUserRoleName());
                request.getSession().setAttribute("userId",user.getId());
                request.getSession().setAttribute("userName",user.getUsername());

                jsonObject.put("status","0");
                jsonObject.put("msg","登录成功！");
                return jsonObject;
            }else {
                jsonObject.put("status","1");
                jsonObject.put("msg","账号或密码不正确，请重新登录！");

                return jsonObject;
            }
        }else{
            jsonObject.put("status","1");
            jsonObject.put("msg","请填写正确信息！");
            return jsonObject;
        }
    }
    /**
     * 退出系统
     * @param session
     *   Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();
        return "login";
    }
    @RequestMapping("404")
    public String page404() {
        return "404";
    }

    @RequestMapping("500")
    public String page500() {
        return "500";
    }
}
