package com.task7.leo.controller;


import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.service.BuyFundService;
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
public class WithdrawController {

    private final WithdrawService withdrawService;

    @Autowired
    public WithdrawController(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdrawForm(Model model) {
        WithdrawForm withdrawForm = new WithdrawForm();
        model.addAttribute("withdrawForm", withdrawForm);
        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String buyFund(Principal principal, @ModelAttribute(value = "withdrawForm") @Valid WithdrawForm withdrawForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "withdraw";
        }

        withdrawService.withdraw(withdrawForm, principal.getName());

        return "success";
    }
}
