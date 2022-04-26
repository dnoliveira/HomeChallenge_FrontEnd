package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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

    public String getPriceStr(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        char c = 0xA3;
        return "" + c + " " + df.format(price);
    }
}
