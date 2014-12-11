package net.bykov.components.impl;

import net.bykov.forms.SignupForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Ievgen on 12/07/2014.
 */
@Component("signupFormValidator")
public class SignupFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SignupForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
//
//        LoginForm form = (LoginForm) target;
//        if(!ApplicationConstants.ROLES.contains(form.getIdRole())) {
//            errors.rejectValue("idRole", "role.required");
//        }
    }

}