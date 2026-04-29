package com.alanf.estoque.dto.categoria;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaResponse {
    private Long id;
    private String nome;
}
