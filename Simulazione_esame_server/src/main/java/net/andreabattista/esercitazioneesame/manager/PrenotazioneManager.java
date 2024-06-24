package net.andreabattista.esercitazioneesame.manager;

import net.andreabattista.esercitazioneesame.dao.CameraDao;
import net.andreabattista.esercitazioneesame.dao.PrenotazioneDao;
import net.andreabattista.esercitazioneesame.dto.CameraDto;
import net.andreabattista.esercitazioneesame.dto.PersonaDto;
import net.andreabattista.esercitazioneesame.dto.PrenotazioneDto;
import net.andreabattista.esercitazioneesame.model.Camera;
import net.andreabattista.esercitazioneesame.model.Persona;
import net.andreabattista.esercitazioneesame.model.Prenotazione;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneManager {
    
    public static List<PrenotazioneDto> getAll() {
        PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
        CameraDao cameraDao = new CameraDao();
        
        List<PrenotazioneDto> dto = new ArrayList<>();
        try {
            List<Prenotazione> prenotazioni = prenotazioneDao.getAll(Prenotazione.class);
            
            for (Prenotazione p : prenotazioni) {
                PrenotazioneDto prenotazioneDto = new PrenotazioneDto();
                prenotazioneDto.setDa(p.getDa());
                prenotazioneDto.setA(p.getA());
                prenotazioneDto.setPrezzo(p.getPrezzo());
                
                List<PersonaDto> personeDto = new ArrayList<>();
                for (Persona per : p.getPersone()) {
                    PersonaDto persona = new PersonaDto();
                    persona.setNome(per.getNome());
                    persona.setCognome(per.getCognome());
                    persona.setDataDiNascita(per.getDataDiNascita());
                    personeDto.add(persona);
                }
                
                prenotazioneDto.setPersone(personeDto);
                
                Camera camera = cameraDao.getByPrenotazione(p.getId());
                CameraDto cameraDto = new CameraDto();
                cameraDto.setNumero(camera.getNumero());
                prenotazioneDto.setCamera(cameraDto);

                dto.add(prenotazioneDto);
            }
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
        
        return dto;
    }
}
