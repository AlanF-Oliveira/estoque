package com.alanf.estoque.controller;

import com.alanf.estoque.dto.produto.ProdutoRequest;
import com.alanf.estoque.dto.produto.ProdutoResponse;
import com.alanf.estoque.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "Gerenciamento dos produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "Cadastra um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Falha na atualizacao")
    public ResponseEntity<ProdutoResponse> salvaProduto(@Valid @RequestBody ProdutoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca produto por id")
    @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoResponse> buscaProdutoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping
    @Operation(summary = "Lista todos os produtos")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso")
    public ResponseEntity <List<ProdutoResponse>> buscaTodosOsProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarTodosOsProdutos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta produto por id")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable Long id){
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza produto por id")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Falha na atualizacao")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoResponse> atualizProdutoPorId(@PathVariable Long id, @Valid @RequestBody ProdutoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(id, request));
    }
}
