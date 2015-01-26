package net.bykov.controllers;

import net.bykov.entities.Result;
import net.bykov.entities.Test;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.security.SecurityUtils;
import net.bykov.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(Model model) {

        long userId = SecurityUtils.getCurrentIdAccount();
        List<Result> results = studentService.listResults(userId);

        model.addAttribute("result", results);
        return "student/results";
    }

    @RequestMapping(value = "/start/{testId}", method = RequestMethod.GET)
    public String beginTest(@PathVariable("testId") Long testId, HttpSession session) {
        Test t;
        try {
            t = studentService.startTest(testId);
        } catch (InvalidUserInputException e) {
            return "404";
        }

        session.setAttribute("test", t);
        session.setAttribute("testId", testId);

        return "redirect:/student/exam";
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public String examineStudent(HttpSession session, Model model) {
        Long testId = (Long) session.getAttribute("testId");
        Test t;

        try {
            t = studentService.startTest(testId);
        } catch (InvalidUserInputException e) {
            return "404";
        }

        int currentQuestion = 1;
        int totalQuestion = t.getQuestionsByIdTest().size();

//        session.setAttribute("testId", testId);
        session.setAttribute("currentQuestion", currentQuestion);
        session.setAttribute("totalQuestions", totalQuestion);
        session.setAttribute("questionTime", t.getTime());
        session.setAttribute("correctAnswers", 0);
        session.setAttribute("percentStatus", (100 / t.getQuestionsByIdTest().size()));
        model.addAttribute("question", t.getQuestionsByIdTest().get(0));
        model.addAttribute("answers", t.getQuestionsByIdTest().get(0).getAnswersByIdQuestion());

        if (currentQuestion == (totalQuestion - 1)) {
            model.addAttribute("isLastAnswer", true);
        } else {
            model.addAttribute("isLastAnswer", false);
        }

        return "student/exam";
    }

    @RequestMapping(value = "/exam", method = RequestMethod.POST)
    public String examineStudentProgress(HttpSession session, Model model) {
        Long testId = (Long) session.getAttribute("testId");
        Test t;

        try {
            t = studentService.startTest(testId);
        } catch (InvalidUserInputException e) {
            return "404";
        }
        int totalQuestion = t.getQuestionsByIdTest().size();

        int currentQuestion = (Integer) session.getAttribute("currentQuestion");
        int correctAnswers = (Integer) session.getAttribute("correctAnswers");

        if (currentQuestion == (totalQuestion - 1)) {
            model.addAttribute("isLastAnswer", true);
        } else {
            model.addAttribute("isLastAnswer", false);
        }

        // TODO Make correctAnswer

        model.addAttribute("question", t.getQuestionsByIdTest().get(currentQuestion));
        model.addAttribute("answers", t.getQuestionsByIdTest().get(currentQuestion).getAnswersByIdQuestion());
//        session.setAttribute("test", t);
        session.setAttribute("currentQuestion", ++currentQuestion);
//        session.setAttribute("totalQuestions", t.getQuestionsByIdTest().size());
//        session.setAttribute("questionTime", t.getTime());
        session.setAttribute("correctAnswers", correctAnswers);
        session.setAttribute("percentStatus", (100 / t.getQuestionsByIdTest().size()) * currentQuestion);

        return "student/exam";
    }

    @RequestMapping(value = "/final", method = RequestMethod.POST)
    public String finalExam(HttpSession session) {
        // TODO Save results to DB
        return "student/results";
    }
}