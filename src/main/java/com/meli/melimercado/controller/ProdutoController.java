package com.meli.melimercado.controller;

import com.meli.melimercado.dto.ProdutoDto;
import com.meli.melimercado.model.Produto;
import com.meli.melimercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> buscarTodos(){
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public String criar(@RequestBody ProdutoDto produtoDto){
        return produtoService.criar(produtoDto);
    }

    @PutMapping("/{id}")
    public String atualizarCompletamente(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizarCompletamente(id, produtoDto);
    }

    @PatchMapping("/{id}")
    public String atualizarParcialmente(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizarParcialmente(id, produtoDto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return produtoService.deletar(id);
    }
}
