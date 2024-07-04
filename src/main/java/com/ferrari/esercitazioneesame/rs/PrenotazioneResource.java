package com.ferrari.esercitazioneesame.rs;

import com.ferrari.esercitazioneesame.dto.PrenotazioneDTO;
import com.ferrari.esercitazioneesame.manager.PrenotazioneManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/prenotazioni")
public class PrenotazioneResource {
    @GET
    @Path("/")
    public Response getAll() {
        try {
            List<PrenotazioneDTO> prenotazioni = PrenotazioneManager.getAll();
            return ResourceUtility.ok(prenotazioni);
        } catch (Exception e) {
            return ResourceUtility.bad(e.getMessage());
        }
    }
}
