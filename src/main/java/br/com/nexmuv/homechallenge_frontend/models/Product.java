package br.com.nexmuv.homechallenge_frontend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
}
