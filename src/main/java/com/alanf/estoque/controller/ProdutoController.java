package com.alanf.estoque.controller;

import com.alanf.estoque.dto.produto.ProdutoRequest;
import com.alanf.estoque.dto.produto.ProdutoResponse;
import com.alanf.estoque.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvaProduto(@RequestBody ProdutoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscaProdutoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping
    public ResponseEntity <List<ProdutoResponse>> buscaTodosOsProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarTodosOsProdutos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable Long id){
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizProdutoPorId(@PathVariable Long id, @RequestBody ProdutoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(id, request));
    }
}
