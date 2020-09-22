package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.User;
import com.ahead.blockchain.servlet.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable(name = "id") Long id){
        return userServlet.getUserById(id);
    }

    @PostMapping("/saveUser")
    public String insertOrUpdateUser(Model model, User user){
        userServlet.insertOrUpdateUser(user);
        return "redirect:/userList";
    }

    @GetMapping("/delUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userServlet.delUser(id);
        return "redirect:/userList";
    }
}
