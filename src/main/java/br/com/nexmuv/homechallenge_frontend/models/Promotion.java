package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.math.BigDecimal;

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
}
