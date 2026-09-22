package com.example.projeto_pdm_2;

public class Slide {

    private String nome, texto;

    private int imagem;

    public Slide(String Nome, int Imagem, String Texto){

        this.nome = Nome;
        this.imagem = Imagem;
        this.texto = Texto;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
