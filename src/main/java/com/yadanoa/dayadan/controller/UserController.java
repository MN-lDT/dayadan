package com.yadanoa.dayadan.controller;

import com.yadanoa.dayadan.service.IUserService;
import com.yadanoa.dayadan.utils.EncryptionUtil;
import com.yadanoa.dayadan.utils.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResultModel name(String username, String password) {
        String result = "已登录";
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (!currentUser.isAuthenticated()) {
            try {
                // 会触发com.shiro.config.MyShiroRealm的doGetAuthenticationInfo方法
                currentUser.login(token);
                result = "登录成功";
                return ResultModel.setSuccess(result);
            } catch (UnknownAccountException e) {
                result = "用户名错误";
            } catch (IncorrectCredentialsException e) {
                result = "密码错误";
            }
        }
        return ResultModel.setFail(result);
    }

    @GetMapping("/logout")
    @ResponseBody
    public ResultModel logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            return ResultModel.setSuccess("退出成功");
        } catch (Exception e) {
            log.error("退出失败",e);
            return ResultModel.setFail("失败");
        }

    }

    @RequiresPermissions("role:update")
    @GetMapping("/role")
    @ResponseBody
    public String name() {
        return "hello";
    }

    @RequiresPermissions("user:select")
    @GetMapping("/role2")
    @ResponseBody
    public String permission() {
        return "hello sel";
    }

    @PostMapping("/register")
    @ResponseBody
    public Boolean register(String username, String password) {
        // 校验 username 的重复
        // 加密密码
        EncryptionUtil encryptionUtil = new EncryptionUtil();
        String encryptionPwd = encryptionUtil.encryption(password, username);
        userService.insertUser(username,encryptionPwd);
        return true;
    }

    public static void main(String[] args) {
        EncryptionUtil encryptionUtil = new EncryptionUtil();
        String encryptionPwd = encryptionUtil.encryption("123456", "lidetian1");
        System.out.println(encryptionPwd);
    }

}
