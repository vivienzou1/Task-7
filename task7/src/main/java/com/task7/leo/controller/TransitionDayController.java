package com.task7.leo.controller;



import com.task7.leo.dto.TransitionDayForm;
import com.task7.leo.service.TransitionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TransitionDayController {

    private final TransitionDayService transitionDayService;

    @Autowired
    public TransitionDayController(TransitionDayService transitionDayService) {
        this.transitionDayService = transitionDayService;
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

        transitionDayService.updatePrice(transitionDayForm);
        transitionDayService.transitionDay();

        return "success";
    }
}
