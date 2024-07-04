package com.ferrari.esercitazioneesame.rs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Configures the Jackson ObjectMapper for serialization and deserialization of Java objects.
 *
 * @author bullbatti
 */
@Provider
public class JacksonConfiguration implements ContextResolver<ObjectMapper> {
    
    private ObjectMapper om;
    
    /**
     * Retrieves the configured ObjectMapper instance based on the provided class.
     *
     * @param aClass The class for which the ObjectMapper is being configured.
     * @return The configured ObjectMapper instance.
     */
    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        om = new ObjectMapper();
        
        SimpleModule module = new SimpleModule("MyConfiguration");
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss")));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        
        om.registerModule(module);
        
        om.configure(SerializationFeature.INDENT_OUTPUT, true);
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        om.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        
        return om;
    }
    
    /**
     * Retrieves the ObjectMapper instance configured by this class.
     *
     * @return The configured ObjectMapper instance.
     */
    public ObjectMapper getObjectMapper() {
        return om;
    }
}
