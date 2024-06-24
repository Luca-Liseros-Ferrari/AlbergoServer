package net.andreabattista.esercitazioneesame.rs;

import net.andreabattista.esercitazioneesame.dto.PrenotazioneDto;
import net.andreabattista.esercitazioneesame.manager.PrenotazioneManager;

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
            List<PrenotazioneDto> prenotazioni = PrenotazioneManager.getAll();
            return ResourceUtility.buildOkResponse(prenotazioni);
        } catch (Exception e) {
            return ResourceUtility.buildBadResponse(e.getMessage());
        }
    }
}
