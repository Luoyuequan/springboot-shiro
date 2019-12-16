package com.shiro.springbootshiro.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luoyuequan
 * @time 2019/12/11 13:45
 */
@Controller
public class HomeController {

//    @RequestMapping(value = {"/index"})
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }

    @RequestMapping(value = {"/403"})
    public ModelAndView forbidden(ModelAndView modelAndView) {
        modelAndView.setViewName("403");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        modelAndView.addObject("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return modelAndView;
    }
}
