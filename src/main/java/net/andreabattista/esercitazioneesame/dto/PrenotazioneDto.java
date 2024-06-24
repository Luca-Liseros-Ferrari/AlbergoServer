package net.andreabattista.esercitazioneesame.dto;

import net.andreabattista.esercitazioneesame.model.Persona;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public class PrenotazioneDto {
    private LocalDateTime da;
    private LocalDateTime a;
    private BigInteger prezzo;
    private List<PersonaDto> persone;
    
    private CameraDto camera;
    
    public LocalDateTime getDa() {
        return da;
    }
    
    public void setDa(LocalDateTime da) {
        this.da = da;
    }
    
    public LocalDateTime getA() {
        return a;
    }
    
    public void setA(LocalDateTime a) {
        this.a = a;
    }
    
    public BigInteger getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo(BigInteger prezzo) {
        this.prezzo = prezzo;
    }
    
    public List<PersonaDto> getPersone() {
        return persone;
    }
    
    public void setPersone(List<PersonaDto> persone) {
        this.persone = persone;
    }
    
    public CameraDto getCamera() {
        return camera;
    }
    
    public void setCamera(CameraDto camera) {
        this.camera = camera;
    }
}
