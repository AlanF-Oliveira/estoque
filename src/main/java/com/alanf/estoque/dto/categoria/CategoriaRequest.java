package com.alanf.estoque.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
}
