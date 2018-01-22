package com.task7.leo.controller;


import com.task7.leo.dto.*;
import com.task7.leo.service.TransitionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {


    private final TransitionDayService transitionDayService;

    @ModelAttribute("depositForm")
    public DepositForm depositForm() {
        return new DepositForm();
    }

    @ModelAttribute("fundCreateForm")
    public FundCreateForm fundCreateForm() {
        return new FundCreateForm();
    }

    @ModelAttribute("transitionDayForm")
    public String transitiondayForm(Model model) {

        TransitionDayForm transitionDayForm = transitionDayService.getForm();
        model.addAttribute("transitionDayForm", transitionDayForm);
        return "transitionday";
    }

    @Autowired
    public EmployeeController(TransitionDayService transitionDayService) { this.transitionDayService = transitionDayService; }

    @RequestMapping(value = "/employee-console")
    public String console() {
        return "employee";
    }
}
