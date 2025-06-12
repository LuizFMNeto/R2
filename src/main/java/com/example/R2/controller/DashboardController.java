package com.example.R2.controller;

import com.example.R2.model.Produto;
import com.example.R2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/dashboard/produto")
    public String adicionarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/"; // Redireciona para a home depois de adicionar
    }
}
