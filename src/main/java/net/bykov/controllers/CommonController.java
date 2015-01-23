package net.bykov.controllers;

import net.bykov.ApplicationConstants;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.LoginForm;
import net.bykov.forms.SignupForm;
import net.bykov.security.CurrentAccount;
import net.bykov.security.SecurityUtils;
import net.bykov.services.CommonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Controller
public class CommonController extends AbstractController implements InitializingBean {

    private final Map<Integer, String> redirects = new HashMap<Integer, String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        redirects.put(ApplicationConstants.ADMIN_ROLE, "/admin/users");
        redirects.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "/advanced_tutor/home");
        redirects.put(ApplicationConstants.TUTOR_ROLE, "/tutor/home");
        redirects.put(ApplicationConstants.STUDENT_ROLE, "/home");
    }

    @Autowired
    protected CommonService commonService;

    @Autowired
    @Qualifier("loginFormValidator")
    private Validator validator;

//    @Autowired
//    @Qualifier("signupFormValidator")
//    private Validator signupValidator;

    @InitBinder("loginForm")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

//    @InitBinder("signupForm")
//    public void initSignupBinder(WebDataBinder binder) {
//        binder.setValidator(validator);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login2(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result,
                         Model model, HttpSession session) {
        return "index";
    }

    @RequestMapping(value={"/signin", "singinFailed"},  method= RequestMethod.GET)
    public String showLogin(Model model){
        model.addAttribute("loginForm", new LoginForm());
//        initRoles(model);
        return "signin";
    }

    @RequestMapping(value={"/myInfo"}, method=RequestMethod.GET)
    public String myInfo(Model model){

        return "redirect:/admin/users";
    }

//    @RequestMapping(value="/signin", method=RequestMethod.POST)
//    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result,
//                        Model model, HttpSession session){
//        try {
//            if(result.hasErrors()) {
////                initRoles(model);
//                return "signin";
//            }
//            User a = commonService.login(loginForm.getLogin(), loginForm.getPassword());
//            session.setAttribute("CURRENT_ACCOUNT", a);
////            return "redirect:student"+redirects.get(loginForm.getIdRole());
//            return "redirect:/admin/users";
//        } catch (InvalidUserInputException e) {
//            result.addError(new ObjectError("", e.getMessage()));
////            initRoles(model);
//            return "signin";
//        }
//    }

//    protected void initRoles(Model model){
//        List<Role> roles = commonService.listAllRoles();
//        model.addAttribute("roles", roles);
//    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String completeSignup(@ModelAttribute("signupForm") SignupForm signupForm, BindingResult result, Model model) {
        try {
            if(result.hasErrors()) {
//                initRoles(model);
                return "signup";
            }


            User a = commonService.signUp(signupForm);
//            session.setAttribute("CURRENT_ACCOUNT", a);
//            return "redirect:student"+redirects.get(loginForm.getIdRole());
            return "signin";
        } catch (InvalidUserInputException e) {
            result.addError(new ObjectError("", e.getMessage()));
//            initRoles(model);
            return "signup";
        }
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public String handleResourceNotFoundException() {
//        return "notFound";
//    }

}