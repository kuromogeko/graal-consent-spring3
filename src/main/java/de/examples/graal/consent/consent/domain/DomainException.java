package de.examples.graal.consent.consent.domain;

public class DomainException extends RuntimeException {
    private ErrorType type;

    public DomainException(String message, ErrorType type) {
        super(message);
        this.type = type;
    }

    public ErrorType getType() {
        return type;
    }
}
