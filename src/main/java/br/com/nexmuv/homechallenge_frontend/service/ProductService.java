package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final Logger log = LoggerFactory.getLogger((ProductService.class));

    @Autowired
    public Environment env;

    public List<Product> findAll(){
        log.debug("Request to get All Products");

        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("qwer", "Hamburguer", new BigDecimal(9.0)) );
        productList.add(new Product("asdf", "Hamburguer X EGG", new BigDecimal(11.0)) );
        productList.add(new Product("zxcv", "Hamburguer X EGG Bacon", new BigDecimal(13.0)) );

        return productList;
    }

}
