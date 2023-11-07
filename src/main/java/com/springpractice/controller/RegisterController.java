package com.springpractice.controller;

import com.springpractice.dao.ReadDbDAO;
import com.springpractice.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        if(user.getPassword().equals(user.getConfirmPassword())){
            String languages = String.join(",",user.getLanguages());
            ReadDbDAO readDB = new ReadDbDAO();
            readDB.addUser(user,languages);
        }
        return "index";
    }
}
