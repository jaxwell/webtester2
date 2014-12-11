package net.bykov.services;

import net.bykov.entities.Test;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.CreateTestForm;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface TutorService {
    List<Test> listTests(User user);

    Test createTest(CreateTestForm form) throws InvalidUserInputException;
}
