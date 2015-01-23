package net.bykov.controllers;

import net.bykov.entities.User;
import net.bykov.security.CurrentAccount;
import net.bykov.security.SecurityUtils;
import net.bykov.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Long userId) {
        adminService.deleteUser(userId);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable("userId") Long userId, Model model) {
        User user = adminService.loadUser(userId);
        model.addAttribute("user", user);
        return "admin/edit";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
    public String saveUser(@PathVariable("userId") Long userId) {
//        adminService.editUser(userId);
        return "admin/users";
    }

    @RequestMapping(value = "/activate/{userId}", method = RequestMethod.GET)
    public String activateUser(@PathVariable("userId") Long userId) {
        adminService.activateUser(userId);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/deactivate/{userId}", method = RequestMethod.GET)
    public String deactivateUser(@PathVariable("userId") Long userId) {
        adminService.deactivateUser(userId);
        return "redirect:/admin/users";
    }
}