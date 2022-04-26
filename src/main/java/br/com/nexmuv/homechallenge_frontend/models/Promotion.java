package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Promotion {
    private String id;
    private PromotionType type;
    private Integer required_qty;
    private Integer free_qty;
    private BigDecimal price;
    private BigDecimal amount;

    public String getPriceStr(){
        String priceStr = "";
        if (price != null) {
            DecimalFormat df = new DecimalFormat("#,###.00");
            char c = 0xA3;
            priceStr = "" + c + " " + df.format(price);
        }
        return priceStr;
    }
}
