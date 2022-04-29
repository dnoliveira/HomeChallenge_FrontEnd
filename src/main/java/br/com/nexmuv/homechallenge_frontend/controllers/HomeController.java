package br.com.nexmuv.homechallenge_frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/shutdown")
    public ModelAndView shutdown() {
        SpringApplication.exit(appContext, () -> 1);
        System.out.println("Spring Boot Aplication is closing......");
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
