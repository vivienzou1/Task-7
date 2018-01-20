package com.task7.leo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FunctionController {
    @PreAuthorize("hasRole('CUSTOMER')")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

        return "home";
    }
    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee() {

        return "employee";
    }
}
