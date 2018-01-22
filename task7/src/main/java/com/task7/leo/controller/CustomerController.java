package com.task7.leo.controller;


import com.task7.leo.domain.Fund;
import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.SellForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.FundRepository;
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
import java.util.List;

@Controller
public class CustomerController {

    private final FundRepository fundRepository;

    @Autowired
    public CustomerController(FundRepository fundRepository) { this.fundRepository = fundRepository; }

    @ModelAttribute("buyForm")
    public BuyForm buyForm() {
        return new BuyForm();
    }

    @ModelAttribute("sellForm")
    public SellForm sellForm() {
        return new SellForm();
    }

    @ModelAttribute("withdrawForm")
    public WithdrawForm withdrawForm() {
        return new WithdrawForm();
    }

    @ModelAttribute("funds")
    public List<Fund> funds() {
        return fundRepository.findAll();
    }

    @RequestMapping(value = "/customer-console")
    public String console() {
        return "customer";
    }
}
