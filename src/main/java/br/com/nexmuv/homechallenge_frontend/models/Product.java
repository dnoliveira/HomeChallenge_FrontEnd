package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private List<Promotion> promotions;

    public Product(String id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
