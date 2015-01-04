package net.bykov.controllers;

import net.bykov.entities.User;
import net.bykov.security.CurrentAccount;
import net.bykov.security.SecurityUtils;
import net.bykov.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {

    @Autowired
    protected AdminService adminService;

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public String home(Model model){
        List<User> users = adminService.listAllUsers();
//        CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
//        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("users", users);
        return "admin/users";
    }

}