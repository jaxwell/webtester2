package net.bykov.dao;

import net.bykov.entities.Test;
import net.bykov.entities.User;

import java.util.List;

public interface TestDao  extends IEntityDao<Test>{
    List<Test> listAllActiveTests();

    List<Test> findByTutor(User user);
}
