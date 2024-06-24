package net.andreabattista.esercitazioneesame.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class ResourceUtility {
    
    public static Response buildOkResponse(Object entity) {
        return Response
            .status(Response.Status.OK)
            .entity(entity)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .build();
    }
    
    public static Response buildBadResponse(Object entity) {
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(entity)
            .type(MediaType.TEXT_PLAIN)
            .build();
    }
    
    public static Response buildUnauthoraizedResponse(String message) {
        return Response
            .status(Response.Status.UNAUTHORIZED)
            .entity(message)
            .type(MediaType.TEXT_PLAIN)
            .build();
    }
}
