package br.com.nexmuv.homechallenge_frontend.controllers;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import br.com.nexmuv.homechallenge_frontend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger((ProductController.class));

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public ModelAndView index() {
        List<Product> productList = productService.findAll();
        ModelAndView mv = new ModelAndView("products/index");
        mv.addObject("productList", productList);
        return mv;
    }

}
