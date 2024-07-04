package com.ferrari.esercitazioneesame.dto;

import java.util.List;

public class AlbergoDTO {

    private Long id;
    private String nome;
    private String luogo;

    private String pIva;
    private List<CameraDTO> camere;

    public AlbergoDTO() {}

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

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public List<CameraDTO> getCamere() {
        return camere;
    }

    public void setCamere(List<CameraDTO> camere) {
        this.camere = camere;
    }

}
