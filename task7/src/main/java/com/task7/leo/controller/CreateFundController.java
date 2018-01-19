package com.task7.leo.controller;


import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.service.CreateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CreateFundController {

    private final CreateFundService createFundService;

    @Autowired
    public CreateFundController(CreateFundService createFundService) {
        this.createFundService = createFundService;
    }

    @RequestMapping(value = "/newfund", method = RequestMethod.GET)
    public String fundCreateForm(Model model) {
        FundCreateForm fundCreateForm = new FundCreateForm();
        model.addAttribute("fundCreateForm", fundCreateForm);
        return "create-fund";
    }

    @RequestMapping(value = "/newfund", method = RequestMethod.POST)
    public String createFund(@ModelAttribute(value = "fundCreateForm") @Valid FundCreateForm fundCreateForm,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "create-fund";
        }

        createFundService.createFund(fundCreateForm);

        return "success";
    }
}
