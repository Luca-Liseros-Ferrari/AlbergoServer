package com.ferrari.esercitazioneesame.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Albergo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String luogo;

    @Column(name = "p_iva")
    private String pIva;

    @OneToMany(mappedBy = "albergo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camera> camere;

    public Albergo() {}

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

    public List<Camera> getCamere() {
        return camere;
    }

    public void setCamere(List<Camera> camere) {
        this.camere = camere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albergo albergo = (Albergo) o;
        return Objects.equals(id, albergo.id)
                && Objects.equals(nome, albergo.nome)
                && Objects.equals(luogo, albergo.luogo)
                && Objects.equals(pIva, albergo.pIva)
                && Objects.equals(camere, albergo.camere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, luogo, pIva, camere);
    }
}