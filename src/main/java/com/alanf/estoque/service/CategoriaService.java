package com.alanf.estoque.service;

import com.alanf.estoque.dto.categoria.CategoriaRequest;
import com.alanf.estoque.dto.categoria.CategoriaResponse;
import com.alanf.estoque.entity.Categoria;
import com.alanf.estoque.exception.NotFoundException;
import com.alanf.estoque.mapper.CategoriaMapper;
import com.alanf.estoque.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponse salvarCategoria(CategoriaRequest request){

        Categoria categoriaEntity = categoriaMapper.paraEntity(request);
        Categoria entitySalva = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.paraDTO(entitySalva);
    }

    public CategoriaResponse buscarCategoriaPorId(Long id){
        Categoria categoriaEntity = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        return categoriaMapper.paraDTO(categoriaEntity);
    }

    public List<CategoriaResponse> listaTodasAsCategorias(){
        return categoriaMapper.paraListaDTO(categoriaRepository.findAll());
    }

    public void deletarCategoriaPorId(Long id){
        if(!categoriaRepository.existsById(id)){
            throw new NotFoundException("Categoria não encontrada");
        }
        categoriaRepository.deleteById(id);
    }

    public CategoriaResponse atualizarCategoriaPorId(Long id, CategoriaRequest request){
        Categoria categoriaEntity = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        categoriaEntity.setNome(request.getNome());
        Categoria entitySalva = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.paraDTO(entitySalva);
    }

}
