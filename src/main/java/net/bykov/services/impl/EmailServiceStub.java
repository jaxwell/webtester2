package net.bykov.services.impl;

import net.bykov.services.EmailService;
import org.springframework.stereotype.Service;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Service("emailService")
public class EmailServiceStub implements EmailService {

    @Override
    public void sendVerificationEmail() {
        //Do nothing
    }

}