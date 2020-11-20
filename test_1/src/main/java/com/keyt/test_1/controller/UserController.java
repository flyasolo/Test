package com.keyt.test_1.controller;


import com.keyt.test_1.bean.UserBean;
import com.keyt.test_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allUserList")
    public String getAllUser(Model model){
        List<UserBean> userBeanList = userService.getAllUser();
        model.addAttribute("users",userBeanList);
//        System.out.println(userBeanList);
        return "allUserList";
    }

}
