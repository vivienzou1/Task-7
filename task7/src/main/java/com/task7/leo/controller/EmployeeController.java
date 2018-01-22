package com.task7.leo.controller;


import com.task7.leo.domain.Fund;
import com.task7.leo.domain.LastTransitionId;
import com.task7.leo.dto.*;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.LastTransitionIdRepository;
import com.task7.leo.service.TransitionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    private final FundRepository fundRepository;

    private final TransitionDayService transitionDayService;
    private final LastTransitionIdRepository lastTransitionIdRepository;

    @Autowired
    public EmployeeController(TransitionDayService transitionDayService, FundRepository fundRepository, LastTransitionIdRepository lastTransitionIdRepository) {
        this.transitionDayService = transitionDayService;
        this.fundRepository = fundRepository;
        this.lastTransitionIdRepository = lastTransitionIdRepository;
    }

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

    @ModelAttribute("funds")
    public List<Fund> funds() {
        return fundRepository.findAll();
    }

    @RequestMapping(value = "/employee-console")
    public String console() {
        return "employee";
    }
}
