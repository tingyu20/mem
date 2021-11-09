package com.cumt.mem.controller;

import com.cumt.mem.bean.User;
import com.cumt.mem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author che
 * @create 2021-11-09 9:43
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*
     **登录调用方法跳转登录页面
     * */
    @RequestMapping("/index")
    private String index() {
        System.out.println(123);
        return "index";
    }
    /*
     **登录成功响应方法
     * @param message
     * @author lgf
     * */
    @RequestMapping(value="/success",method = {RequestMethod.POST, RequestMethod.GET})
    private String ok() {
        return "login_success";
    }
    /*
     **输入账号密码登录校验方法
     * @param message
     * @author lgf
     * */
    @RequestMapping(value="/loginPage",method = {RequestMethod.POST, RequestMethod.GET})
    private String login(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("username");
        String id = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null,name,id,null,null,null));
        System.out.println(123);
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", name);
            //   跳回登录页面
            return "login";

        } else {
            // 登录 成功
            // 保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", loginUser);
            //跳到成功页面login_success.html
            return "login_success";
        }
    }

}















