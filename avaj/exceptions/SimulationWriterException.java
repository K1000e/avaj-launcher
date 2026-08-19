package exceptions;

public class SimulationWriterException extends RuntimeException {
    public SimulationWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}