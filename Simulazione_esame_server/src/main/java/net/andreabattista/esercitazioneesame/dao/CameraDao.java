package net.andreabattista.esercitazioneesame.dao;

import net.andreabattista.esercitazioneesame.model.Camera;
public class CameraDao extends BaseDao {
    
    public Camera getByPrenotazione(Long idPrenotazione) {
        try {
            return entityManager.createNamedQuery("Camera.getByPrenotazione", Camera.class)
                .setParameter("idPrenotazione", idPrenotazione)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
