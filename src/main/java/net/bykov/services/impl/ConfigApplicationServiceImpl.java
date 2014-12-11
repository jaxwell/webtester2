package net.bykov.services.impl;

import net.bykov.services.ConfigApplicationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Service
public class ConfigApplicationServiceImpl implements ConfigApplicationService {

    @Value("${net.bykov.supportEmailAddress}")
    private String supportEmailAddress;

    @Value("${net.bykov.cssJsVersion}")
    private String cssJsVersion;

    @Override
    public String getSupportEmailAddress() {
        return supportEmailAddress;
    }

    @Override
    public String getCssJsVersion() {
        return cssJsVersion;
    }

}