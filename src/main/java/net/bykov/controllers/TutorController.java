package net.bykov.controllers;

import net.bykov.dao.UserDao;
import net.bykov.entities.Test;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.CreateTestForm;
import net.bykov.security.CurrentAccount;
import net.bykov.security.SecurityUtils;
import net.bykov.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController {

//    @RequestMapping(value="/home", method= RequestMethod.GET)
//    public String home(){
//        return "tutor/home";
//    }

    @Autowired
    protected TutorService tutorService;

    @RequestMapping(value = "/createTest", method = RequestMethod.GET)
    public String createTest(Model model) {
        model.addAttribute("createTestForm", new CreateTestForm());
        return "tutor/createTest";
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public String completeCreateTest(@ModelAttribute("createTest") CreateTestForm createTestForm, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                // TODO Create verification input data
            }
            CurrentAccount user = (CurrentAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Test test = tutorService.createTest(createTestForm, user);

            return "student/tests";
        } catch (InvalidUserInputException e) {
            result.addError(new ObjectError("", e.getMessage()));
            return "student/tests";
        }
    }

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String showTests(Model model) {
        long userId = SecurityUtils.getCurrentIdAccount();
        List<Test> tests = tutorService.listTests(userId);
        model.addAttribute("tests", tests);
        return "tutor/tests";
    }

}