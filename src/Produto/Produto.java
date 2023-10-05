package Produto;

import java.util.ArrayList;

public abstract class Produto {


    private String descricao;
    private int estoque;
    private String validade;
    private double preco;
    private String fornecedor;

    public Produto(String descricao, int estoque, String validade, double preco, String fornecedor) {
        setDescricao(descricao);
        setEstoque(estoque);
        setValidade(validade);
        setPreco(preco);
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }



}
