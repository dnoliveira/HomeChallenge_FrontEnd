package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.Product;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;
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

@Service
public class ProductService {
    private final Logger log = LoggerFactory.getLogger((ProductService.class));

    public Environment env;

    private WebClient webClient;

    public ProductService(Environment env, WebClient webClient){
        this.env = env;
        this.webClient = webClient;
    }

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

            for (Product product: productList) {
                fixPriceOfProduct(product);
            }

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
            fixPriceOfProduct(product);

        } catch (WebClientResponseException wex){
            //TODO - Tratar o retorno quando nao existir produt
        }

        return product;
    }

    private void fixPriceOfProduct(Product product){
        BigDecimal price = product.getPrice();
        BigDecimal divisor = new BigDecimal(100.0);
        product.setPrice(price.divide(divisor));

        List<Promotion> promotionList = product.getPromotions();
        if (promotionList != null && promotionList.size() > 0) {
            for (Promotion promotion : promotionList) {
                price = promotion.getPrice();
                if (price != null) {
                    promotion.setPrice(price.divide(divisor));
                }
            }
        }
    }

}
