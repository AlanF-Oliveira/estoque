package com.alanf.estoque.mapper;

import com.alanf.estoque.dto.categoria.CategoriaResponse;
import com.alanf.estoque.dto.produto.ProdutoRequest;
import com.alanf.estoque.dto.produto.ProdutoResponse;
import com.alanf.estoque.entity.Categoria;
import com.alanf.estoque.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "categoria", source = "categoria")
    Produto paraEntity(ProdutoRequest request, Categoria categoria);

    ProdutoResponse paraDTO(Produto produto);

    List<ProdutoResponse> paraListaDTO(List<Produto> produto);
}
