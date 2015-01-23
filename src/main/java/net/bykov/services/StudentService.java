package net.bykov.services;

import net.bykov.entities.Test;
import net.bykov.entities.Result;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface StudentService {
    List<Test> listAllActiveTests();

    List<Result> listResults(long id_student);

}
