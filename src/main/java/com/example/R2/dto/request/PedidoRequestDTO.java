package com.example.R2.dto.request;

import com.example.R2.model.Produto;
import com.example.R2.model.Usuario;

import java.util.Date;

public class PedidoRequestDTO {
    //Atributos da classe
    private Long idUsuario;
    private Usuario usuario;
    private Date data;
    private String status;
    private Double valorTotal;
    private String enderecoEntrega;
    private Produto itens;

    //Contrutor para importar atributos da classe
    public PedidoRequestDTO() {}

    // Contrutor completo
    public PedidoRequestDTO(Long idUsuario, Usuario usuario, Date data, String status, Double valorTotal, String enderecoEntrega, Produto itens) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.data = data;
        this.status = status;
        this.valorTotal = valorTotal;
        this.enderecoEntrega = enderecoEntrega;
        this.itens = itens;
    }

    //Getters and Setters
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public Produto getItens() {
        return itens;
    }
    public void setItens(Produto itens) {
        this.itens = itens;
    }
}
