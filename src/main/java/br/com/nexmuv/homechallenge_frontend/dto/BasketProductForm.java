package br.com.nexmuv.homechallenge_frontend.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasketProductForm {
    @NotBlank
    @NotNull
    private String id;
}
