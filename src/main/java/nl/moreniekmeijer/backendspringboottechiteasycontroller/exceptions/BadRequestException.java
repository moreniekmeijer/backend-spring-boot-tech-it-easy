package nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
