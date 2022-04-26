package br.com.nexmuv.homechallenge_frontend.controllers;

import br.com.nexmuv.homechallenge_frontend.dto.BasketProductForm;
import br.com.nexmuv.homechallenge_frontend.models.Basket;
import br.com.nexmuv.homechallenge_frontend.models.Product;
import br.com.nexmuv.homechallenge_frontend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {
    @Resource(name = "sessionBasket")
    Basket sessionBasket;

    private final ProductService productService;

    public BasketController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public ModelAndView show(BasketProductForm basketProductForm) {
        System.out.println(basketProductForm);
        System.out.println(sessionBasket);
        ModelAndView mv = new ModelAndView("basket/show");
        mv.addObject("basket", sessionBasket);

        return mv;
    }

    @PostMapping("")
    public ModelAndView addProduct(BasketProductForm basketProductForm) {
        System.out.println(basketProductForm);

        if (basketProductForm != null && basketProductForm.getId() != null) {
            Product product = productService.findOne(basketProductForm.getId());
            sessionBasket.add(product);
        }

        ModelAndView mv = new ModelAndView("basket/show");
        mv.addObject("basket", sessionBasket);

        return mv;
    }
}
