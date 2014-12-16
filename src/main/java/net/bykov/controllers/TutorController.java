package net.bykov.controllers;

import net.bykov.forms.CreateTestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController {

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String home(){
        return "tutor/home";
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.GET)
    public String createTest(Model model) {

        return "tutor/createTest";
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public String completeCreateTest(@ModelAttribute("createTest")CreateTestForm createTestForm, BindingResult result, Model model) {

        return "tutor/tests";
    }
}