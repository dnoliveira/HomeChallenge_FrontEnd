package br.com.nexmuv.homechallenge_frontend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private Promotion promotion;

    public Product(String id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
