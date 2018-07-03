package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    //Add request mapping for /leader
    @GetMapping("/leaders")
    public String showLeader(){
        return "leaders";
    }


    //Add request mapping for /systems
    @GetMapping("/systems")
    public String showSystem(){
        return "systems";
    }


}
