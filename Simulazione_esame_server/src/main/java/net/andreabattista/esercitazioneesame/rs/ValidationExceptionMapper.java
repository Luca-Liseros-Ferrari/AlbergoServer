package net.andreabattista.esercitazioneesame.rs;


import net.andreabattista.esercitazioneesame.manager.ValidationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException e) {
        return ResourceUtility.buildUnauthoraizedResponse(e.getMessage());
    }
}
