package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final Logger log = LoggerFactory.getLogger((ProductService.class));

    @Autowired
    public Environment env;

    @Autowired
    private WebClient webClient;

    public List<Product> findAll(){
        log.debug("Request to get All Products");

        List<Product> productList = new ArrayList<Product>();
        try {
            Mono<List<Product>> monoProductList = this.webClient
                    .method(HttpMethod.GET)
                    .uri("/products")
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Product>>() {});

            productList = monoProductList.block();
        } catch (WebClientResponseException wex){
            //TODO - Tratar o retorno quando a lista de produtos for vazia
        }

        return productList;
    }

    public Product findOne(String id) {
        log.debug("Request to get one Product id: " + id);

        Product product = null;

        try {
            Mono<Product> monoProduct = this.webClient
                    .method(HttpMethod.GET)
                    .uri("/products/" + id)
                    .retrieve()
                    .bodyToMono(Product.class);

            product = monoProduct.block();
        } catch (WebClientResponseException wex){
            //TODO - Tratar o retorno quando nao existir produt
        }

        return product;
    }

}
