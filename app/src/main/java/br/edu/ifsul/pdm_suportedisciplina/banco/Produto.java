package br.edu.ifsul.pdm_suportedisciplina.banco;

public class Produto {

    private String descricao;
    private float preco;

    public Produto(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public float getPreco(){
        return this.preco;
    }
}
