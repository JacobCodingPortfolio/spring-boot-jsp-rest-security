package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }


    //Add request mapping for acces denied - access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }


}















