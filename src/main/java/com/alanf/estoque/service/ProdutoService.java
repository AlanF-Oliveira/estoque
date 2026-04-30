package com.alanf.estoque.service;

import com.alanf.estoque.dto.produto.ProdutoRequest;
import com.alanf.estoque.dto.produto.ProdutoResponse;
import com.alanf.estoque.entity.Categoria;
import com.alanf.estoque.entity.Produto;
import com.alanf.estoque.mapper.ProdutoMapper;
import com.alanf.estoque.repository.CategoriaRepository;
import com.alanf.estoque.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoResponse salvarProduto(ProdutoRequest request){
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Produto entity = produtoMapper.paraEntity(request, categoria);
        Produto entitySalva = produtoRepository.save(entity);
        return produtoMapper.paraDTO(entitySalva);
    }

    public ProdutoResponse buscarProdutoPorId(Long id){
        Produto produtoEntity = produtoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        return  produtoMapper.paraDTO(produtoEntity);
    }

    public List<ProdutoResponse> listarTodosOsProdutos(){
        return produtoMapper.paraListaDTO(produtoRepository.findAll());
    }

    public void deletarProdutoPorId(Long id){
       if (!produtoRepository.existsById(id)){
           throw new RuntimeException("Produto não encontrado");
       }
       produtoRepository.deleteById(id);
    }

}
