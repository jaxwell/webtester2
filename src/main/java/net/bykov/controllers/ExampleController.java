package net.bykov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Controller
@RequestMapping(value="/example")
public class ExampleController {

    @RequestMapping(value="/login1")
    public void function1(){}

    @RequestMapping(value="/login2", method={RequestMethod.POST})
    public void function2(){}

    @RequestMapping(value="/login3", method={RequestMethod.POST, RequestMethod.PUT})
    public void function3(){}

    @RequestMapping(value="/pets/{petId}")
    public void function4(@PathVariable String petId){}

    @RequestMapping(value="/pets/{petId}", headers="Content-Type=application/json")
    public void function5(@PathVariable String petId){}

    @RequestMapping(value="/test", headers="nedis=test1")
    public void function6(){}

    @RequestMapping(value="/test", params="myParam=myValue")
    //test?myParam=myValue
    public void function7(){}
}
