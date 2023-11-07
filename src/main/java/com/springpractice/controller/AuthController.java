package com.springpractice.controller;

import com.springpractice.dao.ReadDbDAO;
import com.springpractice.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final ReadDbDAO readDB;
    public AuthController() {
        readDB = new ReadDbDAO();
    }

    @RequestMapping("/")
    public String loginPage(){
        return "index";
    }

    @RequestMapping(value = "/home-page", method = RequestMethod.POST)
    public String homeRedirect(@RequestParam("email") String email, @RequestParam("password") String pass, Model model){
        User loggedInUser = readDB.loginUser(email, pass);

        if(loggedInUser!=null){
            model.addAttribute("user",loggedInUser);
            return "home";
        }
        model.addAttribute("error",true);
        return "index";
    }
}
