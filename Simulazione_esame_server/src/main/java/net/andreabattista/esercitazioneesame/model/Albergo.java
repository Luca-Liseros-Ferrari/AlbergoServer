package net.andreabattista.esercitazioneesame.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Albergo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String indirizzo;
    
    @Column(nullable = false, unique = true)
    private String pIva;
    
    @Column
    private Integer stelle;
    
    @Column
    private boolean wifi;
    
    @Column
    private boolean colazione;
    
    @OneToMany
    @JoinTable(name = "alberghi_camere",
        joinColumns = @JoinColumn( name = "albergo_id"),
        inverseJoinColumns = @JoinColumn(name = "camera_id"))
    private List<Camera> camere;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albergo albergo = (Albergo) o;
        return Objects.equals(id, albergo.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
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
    
    public String getIndirizzo() {
        return indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    public String getpIva() {
        return pIva;
    }
    
    public void setpIva(String pIva) {
        this.pIva = pIva;
    }
    
    public Integer getStelle() {
        return stelle;
    }
    
    public void setStelle(Integer stelle) {
        this.stelle = stelle;
    }
    
    public boolean isWifi() {
        return wifi;
    }
    
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
    
    public boolean isColazione() {
        return colazione;
    }
    
    public void setColazione(boolean colazione) {
        this.colazione = colazione;
    }
    
    public List<Camera> getCamere() {
        return camere;
    }
    
    public void setCamere(List<Camera> camere) {
        this.camere = camere;
    }
}
