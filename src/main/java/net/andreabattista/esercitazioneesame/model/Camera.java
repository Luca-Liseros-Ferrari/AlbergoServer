package net.andreabattista.esercitazioneesame.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NamedQueries({
    @NamedQuery(name = "Camera.getByPrenotazione", query = "select c " +
        "from net.andreabattista.esercitazioneesame.model.Camera c " +
        "join c.prenotazioni p " +
        "where p.id = :idPrenotazione"),
})

@Entity
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer numero;
    
    @Column
    private Integer letti;
    
    @Column
    private Integer bagni;
    
    @OneToMany
    @JoinTable(name = "camera_prenotazioni",
        joinColumns = @JoinColumn( name = "camera_id"),
        inverseJoinColumns = @JoinColumn(name = "prenotazione_id"))
    private List<Prenotazione> prenotazioni;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(id, camera.id);
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
    
    public Integer getLetti() {
        return letti;
    }
    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
    public void setLetti(Integer letti) {
        this.letti = letti;
    }
    
    public Integer getBagni() {
        return bagni;
    }
    
    public void setBagni(Integer bagni) {
        this.bagni = bagni;
    }
    
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
    
    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}

