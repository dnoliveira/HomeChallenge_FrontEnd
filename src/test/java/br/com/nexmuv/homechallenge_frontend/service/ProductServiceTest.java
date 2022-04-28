package br.com.nexmuv.homechallenge_frontend.service;


import br.com.nexmuv.homechallenge_frontend.controllers.ProductController;
import br.com.nexmuv.homechallenge_frontend.models.Product;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @BeforeEach
    public void setup(){

    }

    @Test
    public void findAllTest(){
        List<Product> productList = this.productService.findAll();
        assertEquals(4, productList.size());
    }

    @Test
    public void findOneTest(){
        Product product = this.productService.findOne("Dwt5F7KAhi");
        assertEquals(10.99, product.getPrice().doubleValue());
    }
}
