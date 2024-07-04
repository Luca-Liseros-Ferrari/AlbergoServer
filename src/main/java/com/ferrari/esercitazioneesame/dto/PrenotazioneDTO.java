package com.ferrari.esercitazioneesame.dto;

import java.util.List;

import java.util.Date;

public class PrenotazioneDTO {

    private CameraDTO camera;

    private  AlbergoDTO albergo;
    private List <PersonaDTO> persona;
    private Long id;
    private Date dataDa;
    private Date dataA;
    private double prezzo;

    public PrenotazioneDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDa() {
        return dataDa;
    }

    public void setDataDa(Date dataDa) {
        this.dataDa = dataDa;
    }

    public Date getDataA() {
        return dataA;
    }

    public void setDataA(Date dataA) {
        this.dataA = dataA;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public CameraDTO getCamera() {
        return camera;
    }

    public void setCamera(CameraDTO camera) {
        this.camera = camera;
    }

    public List<PersonaDTO> getPersona() {
        return persona;
    }

    public void setPersona(List<PersonaDTO> persona) {
        this.persona = persona;
    }

    public AlbergoDTO getAlbergo() {
        return albergo;
    }

    public void setAlbergo(AlbergoDTO albergo) {
        this.albergo = albergo;
    }
}

