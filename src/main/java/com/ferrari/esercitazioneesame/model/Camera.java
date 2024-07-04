package com.ferrari.esercitazioneesame.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "albergo_id", nullable = false)
    private Albergo albergo;

    @OneToMany(mappedBy = "camera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prenotazione> prenotazioni;

    public Camera() {}

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

    public Albergo getAlbergo() {
        return albergo;
    }

    public void setAlbergo(Albergo albergo) {
        this.albergo = albergo;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(id, camera.id) && Objects.equals(nome, camera.nome)
                && Objects.equals(categoria, camera.categoria)
                && Objects.equals(albergo, camera.albergo)
                && Objects.equals(prenotazioni, camera.prenotazioni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria, albergo, prenotazioni);
    }
}
