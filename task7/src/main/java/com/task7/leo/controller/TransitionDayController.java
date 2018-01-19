package com.task7.leo.controller;


import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.SellForm;
import com.task7.leo.dto.TransitionDayForm;
import com.task7.leo.repositories.FundRepository;
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
import java.util.List;

@Controller
public class TransitionDayController {

    private final TransitionDayService transitionDayService;
    private final FundRepository fundRepository;

    @Autowired
    public TransitionDayController(TransitionDayService transitionDayService, FundRepository fundRepository) {
        this.transitionDayService = transitionDayService;
        this.fundRepository = fundRepository;
    }

    @RequestMapping(value = "/transitionday", method = RequestMethod.GET)
    public String transitiondayForm(Model model) {

        TransitionDayForm transitionDayForm = transitionDayService.getForm();
        model.addAttribute("transitionDayForm", transitionDayForm);
        return "transitionday";
    }

    @RequestMapping(value = "/transitionday", method = RequestMethod.POST)
    public String transitionday(@ModelAttribute(value = "transitionDayForm") @Valid TransitionDayForm transitionDayForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "transitionday";
        }

        transitionDayService.transitionDay(new Date());

        return "success";
    }
}
