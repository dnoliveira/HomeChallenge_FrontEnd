package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Checkout {
    private List<CheckoutProduct> checkoutProductList = new ArrayList<CheckoutProduct>();
    private BigDecimal total;
    private BigDecimal totalPromos;
    private BigDecimal totalPayable;

    public String getTotalStr(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        char c = 0xA3;
        return "" + c + " " + df.format(total);
    }

    public String getTotalPromosStr(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        char c = 0xA3;
        return "" + c + " " + df.format(totalPromos);
    }

    public String getTotalPayableStr(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        char c = 0xA3;
        return "" + c + " " + df.format(totalPayable);
    }
}
