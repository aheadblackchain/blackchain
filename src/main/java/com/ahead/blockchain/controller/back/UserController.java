package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.User;
import com.ahead.blockchain.servlet.UserServlet;
import com.ahead.blockchain.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class UserController {

    @Autowired
    private UserServlet userServlet;

    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("userList", userServlet.userList());
        return "back/userlist";
    }

    @GetMapping("/login")
    public String toLoginPage(){
        return "back/login";
    }

    @PostMapping("/login")
    public String login(Model model, User user, HttpSession session){
        user.setPassWord(Md5Util.MD5(user.getPassWord()));
        if(userServlet.login(user) == 1){
            session.setAttribute("userName", user.getUserName());
            return "redirect:/userList";
        }else{
            session.invalidate();
            model.addAttribute("loginErr", "用户名或者密码错误");
            return "back/login";
        }
    };

    @PostMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable(name = "id") Long id){
        return userServlet.getUserById(id);
    }

    @PostMapping("/saveUser")
    public String insertOrUpdateUser(User user){
        user.setPassWord(user.getIsUpdatePassWord() ? Md5Util.MD5(user.getPassWord()) : user.getPassWord());
        userServlet.insertOrUpdateUser(user);
        return "redirect:/userList";
    }

    @GetMapping("/delUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userServlet.delUser(id);
        return "redirect:/userList";
    }
}
