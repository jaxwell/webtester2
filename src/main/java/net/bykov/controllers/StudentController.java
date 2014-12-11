package net.bykov.controllers;

import net.bykov.entities.Test;
import net.bykov.services.StudentService;
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
@RequestMapping("/student")
public class StudentController extends AbstractController {

    @Autowired
    protected StudentService studentService;

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String home(){
        return "student/home";
    }


    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String tests(Model model) {
        List<Test> tests = studentService.listAllActiveTests();
        model.addAttribute("tests", tests);
        return "student/tests";
    }

//    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
//    public String results(Model model, HttpSession session) {
//        List<Result> results = studentService.listResult(session.getAttribute("id"));
//        model.addAttribute("statistics", results);
//        return "student/results";
//    }
}