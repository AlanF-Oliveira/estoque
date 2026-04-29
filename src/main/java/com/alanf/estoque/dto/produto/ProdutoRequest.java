package com.alanf.estoque.dto.produto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoRequest {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Long categoriaId;
}
