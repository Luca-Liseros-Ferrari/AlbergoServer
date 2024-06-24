package net.andreabattista.esercitazioneesame.manager;

import net.andreabattista.esercitazioneesame.dao.*;
import net.andreabattista.esercitazioneesame.model.Albergo;
import net.andreabattista.esercitazioneesame.model.Camera;
import net.andreabattista.esercitazioneesame.model.Persona;
import net.andreabattista.esercitazioneesame.model.Prenotazione;
import net.datafaker.Faker;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class PersistData {
    
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALIAN);
        BaseDao.initFactory("DefaultPersistenceUnit");
        
        
        PersonaDao personaDao = new PersonaDao();
//        for (int i = 0; i < 10; ++i) {
//            Persona persona = new Persona();
//            persona.setNome(faker.name().firstName());
//            persona.setCognome(faker.name().lastName());
//            persona.setDataDiNascita(faker.date().birthday().toLocalDateTime().toLocalDate());
//            persona.setCodiceFiscale(UUID.randomUUID().toString());
//            personaDao.save(persona);
//        }
        
        PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
//        List<Persona> persone = personaDao.getAll(Persona.class);
//        for(int i = 1; i <= 4; ++i) {
//            Prenotazione prenotazione = new Prenotazione();
//            prenotazione.setDa(faker.date().birthday().toLocalDateTime().withYear(2025));
//            prenotazione.setA(prenotazione.getDa().plusDays(faker.number().numberBetween(1, 4)));
//            prenotazione.setPrezzo(new BigInteger(String.valueOf(faker.number().numberBetween(60, 250))));
//
//            List<Persona> personePrenotazione = new ArrayList<>();
//            for (int j = 0; j < i; ++j) {
//                int personaDaAggiungere = faker.number().numberBetween(0, persone.size());
//                personePrenotazione.add(persone.get(personaDaAggiungere));
//                persone.remove(personaDaAggiungere);
//            }
//
//            prenotazione.setPersone(personePrenotazione);
//            prenotazioneDao.save(prenotazione);
//        }
        
        CameraDao cameraDao = new CameraDao();
//        List<Prenotazione> prenotazioni = prenotazioneDao.getAll(Prenotazione.class);
//        for (int i = 0; i < 10; ++i) {
//            int prenotazioniCounter = prenotazioneDao.getAll(Prenotazione.class).size();
//
//            Camera camera = new Camera();
//            camera.setNumero(faker.number().numberBetween(1, 100));
//
//            List<Prenotazione> prenotazioniCamera = new ArrayList<>();
//            if(prenotazioniCounter > 0 && faker.bool().bool()) {
//                int prenotazioneDaAggiungere = faker.number().numberBetween(0, prenotazioni.size());
//                prenotazioniCamera.add(prenotazioni.get(prenotazioneDaAggiungere));
//                prenotazioni.remove(prenotazioneDaAggiungere);
//                camera.setPrenotazioni(prenotazioniCamera);
//                --prenotazioniCounter;
//
//                camera.setLetti(camera.getPrenotazioni().getFirst().getPersone().size());
//            } else {
//                camera.setLetti(faker.number().numberBetween(1, 4));
//
//            }
//
//            camera.setBagni(faker.number().numberBetween(1, 2));
//            cameraDao.save(camera);
//        }
        
        AlbergoDao albergoDao = new AlbergoDao();
        List<Camera> camere = cameraDao.getAll(Camera.class);
        
        for (int i = 0; i < 2; ++i) {
            Albergo albergo = new Albergo();
            albergo.setNome(faker.name().title());
            albergo.setIndirizzo(faker.address().fullAddress());
            albergo.setpIva(String.valueOf(faker.number().numberBetween(111111, 999999)));
            
            List<Camera> camereDaAggiungere = new ArrayList<>();
            for (int j = 0; j < 5; ++j) {
                int cameraScelta = faker.number().numberBetween(0, camere.size());
                camereDaAggiungere.add(camere.get(cameraScelta));
                camere.remove(cameraScelta);
            }
            
            albergo.setCamere(camereDaAggiungere);
            albergo.setWifi(faker.bool().bool());
            albergo.setColazione(faker.bool().bool());
            albergo.setStelle(faker.number().numberBetween(1, 5));
            
            albergoDao.save(albergo);
        }
        
        BaseDao.closeFactory();
    }
}
