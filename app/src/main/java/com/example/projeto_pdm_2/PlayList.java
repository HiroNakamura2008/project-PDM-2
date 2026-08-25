package com.example.projeto_pdm_2;

public class PlayList {

    private String nome;

    private int musica;

    public PlayList(String Nome, int Musica){

        this.nome = Nome;
        this.musica = Musica;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getMusica() {
        return musica;
    }

    public void setMusica(int Musica) {
        this.musica = Musica;
    }
}
