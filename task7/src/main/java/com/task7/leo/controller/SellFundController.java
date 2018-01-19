package com.task7.leo.controller;


import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.SellForm;
import com.task7.leo.service.BuyFundService;
import com.task7.leo.service.SellFundService;
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
public class SellFundController {

    private final SellFundService sellFundService;

    @Autowired
    public SellFundController(SellFundService sellFundService) {
        this.sellFundService = sellFundService;
    }

    @RequestMapping(value = "/sellfund", method = RequestMethod.GET)
    public String sellForm(Model model) {
        SellForm sellForm = new SellForm();
        model.addAttribute("sellForm", sellForm);
        return "sell-fund";
    }

    @RequestMapping(value = "/sellfund", method = RequestMethod.POST)
    public String buyFund(Principal principal, @ModelAttribute(value = "sellForm") @Valid SellForm sellForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "sell-fund";
        }

        sellFundService.sellFund(sellForm, principal.getName());

        return "success";
    }
}
