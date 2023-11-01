package com.meli.melimercado.service;

import com.meli.melimercado.dto.ProdutoDto;
import com.meli.melimercado.model.Produto;
import com.meli.melimercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
       return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public String criar(ProdutoDto produtoDto){
        Produto produto = new Produto();
        produto.setNome(produtoDto.getNome());
        produto.setValor(produtoDto.getValor());
        produtoRepository.save(produto);
        return "Produto criado com sucesso!";
    }

    public String atualizarCompletamente(Long id, ProdutoDto produtoDto) {
        Produto produtoEncontrado = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto de id " + id + " não encontrado"));

        produtoEncontrado.setNome(produtoDto.getNome());
        produtoEncontrado.setValor(produtoDto.getValor());

        produtoRepository.save(produtoEncontrado);
        return "Produto atualizado com sucesso!";
    }

    public String atualizarParcialmente(Long id, ProdutoDto produtoDto){
        Produto produtoEncontrado = produtoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Produto de id" + id + "não encontrado"));
        if (produtoDto.getNome() !=  null){
            produtoEncontrado.setNome(produtoDto.getNome());
        }
        if (produtoDto.getValor() != null) {
            produtoEncontrado.setValor(produtoDto.getValor());
        }

        produtoRepository.save(produtoEncontrado);
        return "Produto atualizado com sucesso!";
    }

    public String deletar(Long id){
        Produto produtoEncontrado = produtoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Produto de id" + id + "não encontrado"));
        produtoRepository.delete(produtoEncontrado);
        return "Produto deletado com sucesso!";
    }
}
