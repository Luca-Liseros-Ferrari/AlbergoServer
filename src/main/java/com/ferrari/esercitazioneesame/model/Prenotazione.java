package com.ferrari.esercitazioneesame.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "findAllPrenotazioni",
                query = "select p from Prenotazione p")
})
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_da")
    private Date dataDa;

    @Column(name = "data_a")
    private Date dataA;

    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "camera_id", nullable = false)
    private Camera camera;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    public Prenotazione() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDa() {
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

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Double.compare(prezzo, that.prezzo) == 0 && Objects.equals(id, that.id)
                && Objects.equals(dataDa, that.dataDa) && Objects.equals(dataA, that.dataA)
                && Objects.equals(camera, that.camera) && Objects.equals(persona, that.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataDa, dataA, prezzo, camera, persona);
    }

    // arrivo all'albergo dalla camera! -- vedi model
    public Albergo getAlbergo() {
      return camera.getAlbergo();
    }
}
