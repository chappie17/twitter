package pl.sdacademy.tweeter.model;

public class TweeterRepositoryException extends RuntimeException {

    public TweeterRepositoryException(String message) {
        super(message);
    }

    public TweeterRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
