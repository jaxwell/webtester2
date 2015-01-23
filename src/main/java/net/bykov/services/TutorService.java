package net.bykov.services;

import net.bykov.entities.Test;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.CreateTestForm;
import net.bykov.security.CurrentAccount;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface TutorService {
    List<Test> listTests(Long userId);

    Test createTest(CreateTestForm form, CurrentAccount user) throws InvalidUserInputException;
}
