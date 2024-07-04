package com.ferrari.esercitazioneesame.dto;

public class CameraDTO {
    private Long id;
    private String nome;
    private String categoria;

    // Costruttori, getters e setters...

    public CameraDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
