package com.task7.leo.controller;


import com.task7.leo.domain.Transition;
import com.task7.leo.repositories.TransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TransitionListController {

    private final TransitionRepository transitionRepository;

    @Autowired
    public TransitionListController(TransitionRepository transitionRepository) {
        this.transitionRepository = transitionRepository;
    }

    @RequestMapping(value = "/transitions", method = RequestMethod.GET)
    public String fundList(Model model) {
        List<Transition> transitions = transitionRepository.findAll();
        model.addAttribute("transitions", transitions);
        return "transition-list";
    }
}
