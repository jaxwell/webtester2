package net.bykov.controllers;

import net.bykov.services.AdvancedTutorService;
import net.bykov.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ievgen on 11/30/2014.
 */
public abstract class AbstractTutorController extends AbstractController {

    @Autowired
    protected TutorService tutorService;

    @Autowired
    protected AdvancedTutorService advancedTutorService;
}