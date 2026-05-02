package com.alanf.estoque.controller;

import com.alanf.estoque.dto.categoria.CategoriaRequest;
import com.alanf.estoque.dto.categoria.CategoriaResponse;
import com.alanf.estoque.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> salvaCategoria(@Valid @RequestBody CategoriaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body((categoriaService.salvarCategoria(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscaCategoriaPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarCategoriaPorId(id));
    }

    @GetMapping
    public ResponseEntity <List<CategoriaResponse>> buscaTodasCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listaTodasAsCategorias());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable Long id){
        categoriaService.deletarCategoriaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> atualizarCategoria(@Valid @PathVariable Long id, @RequestBody CategoriaRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizarCategoriaPorId(id, request));
    }


}
