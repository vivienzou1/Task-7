package com.task7.leo.controller;


import com.task7.leo.dto.DepositForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.service.DepositService;
import com.task7.leo.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String depositForm(Model model) {
        DepositForm depositForm = new DepositForm();
        model.addAttribute("depositForm", depositForm);
        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String buyFund(@ModelAttribute(value = "depositForm") @Valid DepositForm depositForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "deposit";
        }

        depositService.deposit(depositForm);

        return "success";
    }
}
