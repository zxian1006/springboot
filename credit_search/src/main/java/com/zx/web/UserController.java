package com.zx.web;

import com.zx.dao.UserRepository;
import com.zx.entity.User;
import com.zx.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by credittone on 2017/4/17.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    /**
     * 用户注册
     * @param uname
     * @param pwd
     * @return
     */
    @RequestMapping("/register")
    public User registerUser(String uname,String pwd){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user =userRepository.save(new User(uname, MD5Util.string2MD5(pwd),Double.parseDouble("0"),sdf.format(new Date())));
        return user;
    }

    /**
     * 用户登陆
     * @param uname
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public String login(String uname,String pwd){
        User user = userRepository.findByName(uname);
        if(user == null){
            return "账号不存在";
        }
        if( !MD5Util.string2MD5(pwd).equals(user.getPwd())){
            return "账号或者密码错误!";
        }else {
            return "ok!";
        }
    }

    @RequestMapping("/changePwd")
    public String changePwd(String uname,String pwd){
        User user = userRepository.findByName(uname);

        if(MD5Util.string2MD5(pwd).equals(user.getPwd())){
            return "密码不能与之前相同!";
        }else {
            userRepository.updatePwd(uname,MD5Util.string2MD5(pwd));
            return "change ok!";
        }
    }
}
