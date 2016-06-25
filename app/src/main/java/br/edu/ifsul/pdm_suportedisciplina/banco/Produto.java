package br.edu.ifsul.pdm_suportedisciplina.banco;

public class Produto {

    private int id;
    private String descricao;
    private float preco;

    public Produto(int id, String descricao, float preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public float getPreco(){
        return this.preco;
    }
}
