package com.alanf.estoque.controller;

import com.alanf.estoque.dto.categoria.CategoriaRequest;
import com.alanf.estoque.dto.categoria.CategoriaResponse;
import com.alanf.estoque.service.CategoriaService;
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
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@Tag(name = "Categorias", description = "Gerenciamento de categorias dos produtos")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    @Operation(summary = "Cadastra uma nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso")
    @ApiResponse(responseCode = "400", description = "Falha no cadastro")
    public ResponseEntity<CategoriaResponse> salvaCategoria(@Valid @RequestBody CategoriaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body((categoriaService.salvarCategoria(request)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca categoria por id")
    @ApiResponse(responseCode = "200", description = "Categoria encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaResponse> buscaCategoriaPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarCategoriaPorId(id));
    }
    @Operation(summary = "Lista todas as categorias")
    @ApiResponse(responseCode = "200", description = "Categorias encontradas com sucesso")
    @GetMapping
    public ResponseEntity <List<CategoriaResponse>> buscaTodasCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listaTodasAsCategorias());
    }
    @Operation(summary = "Deleta categoria por id")
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable Long id){
        categoriaService.deletarCategoriaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualiza categoria por id")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "400", description = "Falha na atualizacao")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> atualizarCategoria(@PathVariable Long id, @Valid  @RequestBody CategoriaRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizarCategoriaPorId(id, request));
    }


}
