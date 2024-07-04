package com.ferrari.esercitazioneesame.manager;

import com.ferrari.esercitazioneesame.dao.*;
import com.ferrari.esercitazioneesame.model.Albergo;
import com.ferrari.esercitazioneesame.model.Camera;
import com.ferrari.esercitazioneesame.model.Persona;
import com.ferrari.esercitazioneesame.dao.*;
import com.ferrari.esercitazioneesame.model.Prenotazione;

import java.util.Date;

public class PersistData {
    public static void main(String[] args) {
        BaseDao.initFactory("DefaultPersistenceUnit");
        // persona
        PersonaDao personaDao = new PersonaDao();
        Persona persona1 = new Persona();
        persona1.setNome("nome1");
        persona1.setCognome("cognome1");
        persona1.setCf("cf1");
        personaDao.save(persona1);
        Persona persona2 = new Persona();
        persona2.setNome("nome2");
        persona2.setCognome("cognome2");
        persona2.setCf("cf2");
        personaDao.save(persona2);
        Persona persona3 = new Persona();
        persona3.setNome("nome3");
        persona3.setCognome("cognome3");
        persona3.setCf("cf3");
        personaDao.save(persona3);

        // albergo
        AlbergoDao albergoDao = new AlbergoDao();
        Albergo albergo1 = new Albergo();
        albergo1.setNome("albergo1");
        albergo1.setLuogo("luogo1");
        albergo1.setpIva("pIva1");
        albergoDao.save(albergo1);
        Albergo albergo2 = new Albergo();
        albergo2.setNome("albergo2");
        albergo2.setLuogo("luogo2");
        albergo2.setpIva("pIva2");
        albergoDao.save(albergo2);
        Albergo albergo3 = new Albergo();
        albergo3.setNome("albergo3");
        albergo3.setLuogo("luogo3");
        albergo3.setpIva("pIva3");
        albergoDao.save(albergo3);

        // camera
        CameraDao cameraDao = new CameraDao();
        Camera camera1 = new Camera();
        camera1.setNome("camera1");
        camera1.setCategoria("categoria1");
        camera1.setAlbergo(albergo1);
        cameraDao.save(camera1);
        Camera camera2 = new Camera();
        camera2.setNome("camera2");
        camera2.setCategoria("categoria2");
        camera2.setAlbergo(albergo2);
        cameraDao.save(camera2);
        Camera camera3 = new Camera();
        camera3.setNome("camera3");
        camera3.setCategoria("categoria3");
        camera3.setAlbergo(albergo3);
        cameraDao.save(camera3);

        // prenotazione
        PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataDa(new Date());
        prenotazione1.setDataA(new Date());
        prenotazione1.setPrezzo(100.0);
        prenotazione1.setCamera(camera1);
        prenotazione1.setPersona(persona1);
        prenotazioneDao.save(prenotazione1);
        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setDataDa(new Date());
        prenotazione2.setDataA(new Date());
        prenotazione2.setPrezzo(200.0);
        prenotazione2.setCamera(camera2);
        prenotazione2.setPersona(persona2);
        prenotazioneDao.save(prenotazione2);
        Prenotazione prenotazione3 = new Prenotazione();
        prenotazione3.setDataDa(new Date());
        prenotazione3.setDataA(new Date());
        prenotazione3.setPrezzo(200.0);
        prenotazione3.setCamera(camera3);
        prenotazione3.setPersona(persona3);
        prenotazioneDao.save(prenotazione3);

        BaseDao.closeFactory();
    }
}