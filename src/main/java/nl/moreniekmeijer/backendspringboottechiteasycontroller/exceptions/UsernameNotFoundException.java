package nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
