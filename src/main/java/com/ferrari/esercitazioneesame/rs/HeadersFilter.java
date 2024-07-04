package com.ferrari.esercitazioneesame.rs;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * A filter class that modifies the headers of HTTP responses to allow Cross-Origin Resource Sharing (CORS).
 *
 * @author bullbatti
 */
@Provider
public class HeadersFilter implements ContainerResponseFilter {
    
    /**
     * Modifies the headers of the HTTP response to include CORS-related headers.
     *
     * @param requestContext  The context of the HTTP request.
     * @param responseContext The context of the HTTP response.
     * @throws IOException If an I/O error occurs while processing the filter.
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "*");
        headers.add("Access-Control-Expose-Headers", "Authorization");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
    }
}
