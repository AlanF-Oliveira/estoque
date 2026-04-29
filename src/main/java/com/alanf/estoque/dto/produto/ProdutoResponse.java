package com.alanf.estoque.dto.produto;

import com.alanf.estoque.dto.categoria.CategoriaResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaResponse categoria;
}
