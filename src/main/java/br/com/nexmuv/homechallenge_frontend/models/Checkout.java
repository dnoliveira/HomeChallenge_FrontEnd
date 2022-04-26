package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Checkout {

    private Map<String, CheckoutProduct> checkoutProductMapMap = new HashMap<String, CheckoutProduct>();
    private BigDecimal total;
    private BigDecimal totalPromos;
    private BigDecimal totalPayable;

}
