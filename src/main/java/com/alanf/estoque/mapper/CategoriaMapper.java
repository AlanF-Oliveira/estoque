package com.alanf.estoque.mapper;

import com.alanf.estoque.dto.categoria.CategoriaRequest;
import com.alanf.estoque.dto.categoria.CategoriaResponse;
import com.alanf.estoque.entity.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria paraEntity(CategoriaRequest request);

    CategoriaResponse paraDTO(Categoria categoria);

    List<CategoriaResponse> paraListaDTO(List<Categoria> categorias);
}