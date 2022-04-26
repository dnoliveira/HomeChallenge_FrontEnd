package br.com.nexmuv.homechallenge_frontend.controllers;

import br.com.nexmuv.homechallenge_frontend.models.Basket;
import br.com.nexmuv.homechallenge_frontend.service.CheckoutService;
import br.com.nexmuv.homechallenge_frontend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController {
    private final Logger log = LoggerFactory.getLogger(CheckoutController.class);

    @Resource(name = "sessionBasket")
    Basket sessionBasket;

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @GetMapping("")
    public ModelAndView show() {
        log.info("CheckoutController.show ['GET'] - sessionBasket: " + sessionBasket.toString());

        ModelAndView mv = new ModelAndView("basket/show");
        mv.addObject("basket", sessionBasket);

        return mv;
    }

}
