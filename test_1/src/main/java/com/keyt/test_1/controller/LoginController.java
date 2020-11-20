package com.keyt.test_1.controller;

import com.keyt.test_1.bean.UserBean;
import com.keyt.test_1.bean.VerifyCode;
import com.keyt.test_1.service.IVerifyCodeGen;
import com.keyt.test_1.service.UserService;
import com.keyt.test_1.serviceImpl.SimpleCharVerifyCodeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeImpl();
        try {
//设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //LOGGER.info(code);
//将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
//设置响应头
            response.setHeader("Pragma", "no-cache");
//设置响应头
            response.setHeader("Cache-Control", "no-cache");
//在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
//设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            //org.slf4j.info("", e);
        }
    }


    @RequestMapping(value = "/checkLongin")
    public String checkLogin(UserBean userBean, Model model, HttpSession session){
        UserBean userBean1 = userService.getUserByUsernameAndPassword(userBean.getUserName(),userBean.getUserPassword());
        if (userBean1!=null){
            return "redirect:/user/allUserList";
        }
        else return "";
    }
}
