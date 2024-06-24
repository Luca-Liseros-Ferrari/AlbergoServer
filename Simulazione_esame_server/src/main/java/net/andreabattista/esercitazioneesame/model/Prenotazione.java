package net.andreabattista.esercitazioneesame.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Prenotazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime da;
    
    @Column(nullable = false)
    private LocalDateTime a;
    
    @Column(nullable = false)
    private BigInteger prezzo;
    
    @ManyToMany
    @JoinTable(name = "prenotazione_persona",
        joinColumns = @JoinColumn( name = "prenotazione_id"),
        inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> persone;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id);
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
    
    public List<Persona> getPersone() {
        return persone;
    }
    
    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }
}
