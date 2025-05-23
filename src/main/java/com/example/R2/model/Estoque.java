package com.example.R2.model;

public class Estoque {
    //Atributos da classe
    private Long id;
    private Produto produto;
    private Long idProduto;
    private int quantidadeDisponivel;

    //Contrutor para importar atributos da classe
    public Estoque() {}

    //Construtor completo
    public Estoque(Long id, Produto produto, Long idProduto, int quantidadeDisponivel) {
        this.id = id;
        this.produto = produto;
        this.idProduto = idProduto;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    //Getter and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
