/**
 * @author William Chen
 * @version 1.0
 */
public class InvalidSearchStringException extends RuntimeException {
    /**
     * overiding constructor for InvalidSearchStringException
     * @param message message to be printed, as specified by RuntimeException
     */
    public InvalidSearchStringException(String message) {
        super(message);
    }
}
