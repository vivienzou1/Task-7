package com.task7.leo.controller;

import com.task7.leo.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class FunctionController {
    @PreAuthorize("hasRole('CUSTOMER')")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Principal principal) {

        return "home";
    }
    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Principal principal) {

        return "employee";
    }
}
