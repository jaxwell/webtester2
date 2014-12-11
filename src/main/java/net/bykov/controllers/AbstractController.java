package net.bykov.controllers;

import net.bykov.services.CommonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ievgen on 11/30/2014.
 */
public abstract class AbstractController {
    protected final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    protected CommonService commonService;
}
