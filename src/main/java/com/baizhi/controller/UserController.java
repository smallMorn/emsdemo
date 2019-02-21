package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @RequestMapping("login")
    public String login(User user, Map map){
        User user1 = userService.selectOne(user);
        if (user1==null){
            map.put("error","用户名或者密码错误");
            return "login";
        }
        return "redirect:/empList.jsp";
    }
    @RequestMapping("selectByPage")
    public @ResponseBody Map selectByPage(int page, int rows){
        return userService.selectByPage(page, rows);
    }
    //注册
    @RequestMapping("register")
    public String register(User user, String number, HttpSession session){
        String code = (String) session.getAttribute("code");
        if (code.equals(number)){
            userService.register(user);
        }else {
            return "regist";
        }
        return "login";
    }
    //删除
    @RequestMapping("multiDelete")
    public @ResponseBody boolean multiDelete(int[] ids){
        try {
            userService.multiDelete(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //根据id查询
    @RequestMapping("selectById")
    public String selectById(int id,Map map){
        User user = userService.selectById(id);
        map.put("user",user);
        return "updateEmp";
    }
    //修改
    @RequestMapping("update")
    public String update(User user){
        userService.update(user);
        return "empList";
    }
}
