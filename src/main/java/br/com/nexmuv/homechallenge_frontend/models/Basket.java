package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Basket {
    private List<Product> productList = new ArrayList<Product>();

    private BigDecimal total = new BigDecimal(0.0);

    public String getTotalFormat(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        char c = 0xA3;
        return "" + c + " " + df.format(total);
    }

    public void add(Product product){
        productList.add(product);
        this.total = this.total.add(product.getPrice());
    }
}
