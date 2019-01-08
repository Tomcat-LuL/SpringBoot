package com.example.controller.sys;

import com.example.pojo.sys.User;
import com.example.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: userController
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2018/12/13下午 1:30
 * Version: 1.0
 */
@Controller
@RequestMapping("/sys")
public class userController{

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser() throws Exception{
        User user = new User();
        user.setUsername("小李子");
        user.setPassword("123456");
        user.setStaffid(1);
        int i = userService.addUser(user);
        if(i>0){
            return "添加成功";
        }else{
            return "添加失败";
        }

    }
}
