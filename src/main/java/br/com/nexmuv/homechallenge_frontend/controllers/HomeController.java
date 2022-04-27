package br.com.nexmuv.homechallenge_frontend.controllers;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping(value = "")
public class HomeController {

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
