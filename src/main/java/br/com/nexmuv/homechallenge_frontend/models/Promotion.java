package br.com.nexmuv.homechallenge_frontend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Promotion {
    private String id;
    private PromotionType type;
    private Integer required_qty;
    private Integer free_qty;
    private BigDecimal price;
    private BigDecimal amount;
}
