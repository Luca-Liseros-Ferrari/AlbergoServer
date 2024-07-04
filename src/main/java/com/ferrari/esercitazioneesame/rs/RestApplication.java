package com.ferrari.esercitazioneesame.rs;

import com.ferrari.esercitazioneesame.dao.BaseDao;
import com.ferrari.esercitazioneesame.model.Albergo;
import com.ferrari.esercitazioneesame.model.Camera;
import com.ferrari.esercitazioneesame.model.Persona;
import com.ferrari.esercitazioneesame.model.Prenotazione;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    
    /**
     * Retrieves the set of resource classes to be registered by this application.
     *
     * @return A set containing the resource classes to be registered.
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        
        classes.add(Albergo.class);
        classes.add(Camera.class);
        classes.add(Prenotazione.class);
        classes.add(Persona.class);
        
        classes.add(PrenotazioneResource.class);
        classes.add(JacksonConfiguration.class);
        classes.add(HeadersFilter.class);
        
        BaseDao.initFactory("DefaultPersistenceUnit");
        
        return classes;
    }
}

