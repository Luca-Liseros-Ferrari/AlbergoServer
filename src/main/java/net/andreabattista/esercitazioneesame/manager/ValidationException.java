package net.andreabattista.esercitazioneesame.manager;

public class ValidationException extends RuntimeException{
    
    public ValidationException() {}
    
    public ValidationException(String message) {
        super(message);
    }
}
