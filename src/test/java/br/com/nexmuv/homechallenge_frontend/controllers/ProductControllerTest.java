package br.com.nexmuv.homechallenge_frontend.controllers;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import br.com.nexmuv.homechallenge_frontend.service.ProductService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebClient webClient;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(this.productController);
    }


    @Test
    public void searchDetailOfProduts() throws Exception {
        Mockito.when(this.productService.findOne("Dwt5F7KAhi")).
                thenReturn(new Product("Dwt5F7KAhi", "Amazing Pizza!", new BigDecimal(10.99)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/products/{id}","Dwt5F7KAhi")
                .accept(MediaType.TEXT_HTML);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                                Matchers.containsString("<b>Id:</b> <span>Dwt5F7KAhi</span><br/>") )
                            )
                .andReturn();

        /*
        Mockito.when(this.productService.findOne("Dwt5F7KAhi")).
                thenReturn(new Product("Dwt5F7KAhi", "Amazing Pizza!", new BigDecimal(10.99)));

        RestAssuredMockMvc
            .given()
                .accept(ContentType.HTML)
            .when()
                .get("/products/{id}","Dwt5F7KAhi")
            .then()
                .statusCode(HttpStatus.OK.value());
         */
    }
}
