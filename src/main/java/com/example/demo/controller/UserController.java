package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title:UserController.java</p >
 * <p>Description:</p >
 *
 * @author Sephinor
 * @time 2019/12/15 12:21
 */
@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value={"/list","/"})
    public String list(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        //指向resources/templates/user/list
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){ return "user/userAdd";}

    @RequestMapping("/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        userService.delete(id);
        return "redirect:/list";
    }
}
