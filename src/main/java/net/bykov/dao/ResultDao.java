package net.bykov.dao;

import net.bykov.entities.Result;

import java.util.List;

public interface ResultDao extends IEntityDao<Result>{
    List<Result> listUserResults(long id_student);
}
