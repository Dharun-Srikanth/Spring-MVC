package com.springpractice.controller;

import com.springpractice.dao.ReadDbDAO;
import com.springpractice.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private ReadDbDAO readDB;

    public HomeController() {
        readDB = new ReadDbDAO();
    }

    @RequestMapping("/home")
    public String loadHome(Model model){
        List<User> allUsers = readDB.allData();
        model.addAttribute("users",allUsers);
        return "home";
    }
}
