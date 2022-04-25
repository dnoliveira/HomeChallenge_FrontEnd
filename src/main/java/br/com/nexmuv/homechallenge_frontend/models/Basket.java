package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Basket {
    private List<Product> productList = new ArrayList<Product>();
    private BigDecimal total;

    public void add(Product product){
        productList.add(product);
        this.total = this.total.add(product.getPrice());
    }
}
