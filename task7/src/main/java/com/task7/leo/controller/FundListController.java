package com.task7.leo.controller;


import com.task7.leo.domain.Fund;
import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.service.CreateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FundListController {

    private final FundRepository fundRepository;

    @Autowired
    public FundListController(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @RequestMapping(value = "/funds", method = RequestMethod.GET)
    public String fundList(Model model) {
        List<Fund> funds = fundRepository.findAll();
        model.addAttribute("funds", funds);
        return "fund-list";
    }
}
