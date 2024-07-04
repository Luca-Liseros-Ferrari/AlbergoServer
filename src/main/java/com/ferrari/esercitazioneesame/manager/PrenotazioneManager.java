package com.ferrari.esercitazioneesame.manager;

import com.ferrari.esercitazioneesame.dao.PrenotazioneDao;
import com.ferrari.esercitazioneesame.dto.AlbergoDTO;
import com.ferrari.esercitazioneesame.dto.CameraDTO;
import com.ferrari.esercitazioneesame.dto.PersonaDTO;
import com.ferrari.esercitazioneesame.dto.PrenotazioneDTO;
import com.ferrari.esercitazioneesame.model.Albergo;
import com.ferrari.esercitazioneesame.model.Camera;
import com.ferrari.esercitazioneesame.model.Persona;
import com.ferrari.esercitazioneesame.model.Prenotazione;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneManager {

    public static List<PrenotazioneDTO> getAll() {

        PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
       // CameraDao cameraDao = new CameraDao();
        List<PrenotazioneDTO> dto = new ArrayList<>();

        try {
            List<Prenotazione> prenotazioni = prenotazioneDao.getAll(Prenotazione.class);

            for (Prenotazione p : prenotazioni) {
                // dto prenotazione
                PrenotazioneDTO prenotazioneDto = new PrenotazioneDTO();

                // prendo l'albergo dalla prenotazione! --
                // l'albergo è inferito, posso raggiungerlo:
                // prenotazione - camera - albergo
                Albergo albergo = p.getAlbergo();
                // dto albergo
                AlbergoDTO albergoDTO = new AlbergoDTO();
                albergoDTO.setNome(albergo.getNome());
                // set albergo prenotazione
                prenotazioneDto.setAlbergo(albergoDTO);

                prenotazioneDto.setDataDa(p.getDa());
                prenotazioneDto.setDataA(p.getDataA());
                prenotazioneDto.setPrezzo(p.getPrezzo());

                Camera camera = p.getCamera();
                CameraDTO cameraDTO = new CameraDTO();
                cameraDTO.setNome(camera.getNome());
                cameraDTO.setCategoria(camera.getCategoria());
                // set camera prenotazione
                prenotazioneDto.setCamera(cameraDTO);

                List<PersonaDTO> prenotazioniPersona = new ArrayList<>();
                Persona persona = p.getPersona();
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setNome(persona.getNome());
                prenotazioniPersona.add(personaDTO);
                // set persona prenotazione
                prenotazioneDto.setPersona(prenotazioniPersona);

                dto.add(prenotazioneDto);
            }
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
        return dto;
    }
}
