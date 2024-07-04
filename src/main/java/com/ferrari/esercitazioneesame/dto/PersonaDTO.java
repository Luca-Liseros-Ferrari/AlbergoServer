package com.ferrari.esercitazioneesame.dto;

public class PersonaDTO {
    private Long id;
    private String nome;
    private String cognome;

    private CameraDTO camera;
    public PersonaDTO() {
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public CameraDTO getCamera() {
        return camera;
    }

    public void setCamera(CameraDTO camera) {
        this.camera = camera;
    }
}