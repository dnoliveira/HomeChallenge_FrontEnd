package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    protected String id;
    protected String name;
    protected BigDecimal price;
    protected List<Promotion> promotions = new ArrayList<>();

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
