package com.task7.leo.controller;


import com.task7.leo.dto.BuyForm;
import com.task7.leo.service.BuyFundService;
import com.task7.leo.service.TransitionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Controller
public class TransactionDayController {

    private final TransitionDayService transitionDayService;

    @Autowired
    public TransactionDayController(TransitionDayService transitionDayService) {
        this.transitionDayService = transitionDayService;
    }

    @RequestMapping(value = "/transitionday", method = RequestMethod.GET)
    public String transactiondayForm(Model model) {
        transitionDayService.transitionDay(new Date());
        return "success";
    }

//    @RequestMapping(value = "/buyfund", method = RequestMethod.POST)
//    public String buyFund(Principal principal, @ModelAttribute(value = "buyForm") @Valid BuyForm buyForm,
//                          BindingResult result) {
//        if (result.hasErrors()) {
//            return "buy-fund";
//        }
//
//        buyFundService.buyFund(buyForm, principal.getName());
//
//        return "success";
//    }
}
