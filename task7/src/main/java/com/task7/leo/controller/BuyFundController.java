package com.task7.leo.controller;


import com.task7.leo.dto.BuyForm;
import com.task7.leo.service.BuyFundService;
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
public class BuyFundController {

    private final BuyFundService buyFundService;

    @Autowired
    public BuyFundController(BuyFundService buyFundService) {
        this.buyFundService = buyFundService;
    }

    @RequestMapping(value = "/buyfund", method = RequestMethod.GET)
    public String buyForm(Model model) {
        BuyForm buyForm = new BuyForm();
        model.addAttribute("buyForm", buyForm);
        return "buy-fund";
    }

    @RequestMapping(value = "/buyfund", method = RequestMethod.POST)
    public String buyFund(Principal principal, @ModelAttribute(value = "buyForm") @Valid BuyForm buyForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "buy-fund";
        }

        buyFundService.buyFund(buyForm, principal.getName());

        return "success";
    }
}
