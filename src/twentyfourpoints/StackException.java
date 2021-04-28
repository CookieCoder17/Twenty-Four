
/**
 * An exception that is thrown when stack underflow occurs.
 * @author Adam Khoukhi
 * @version 1.0
 */
public class StackException extends RuntimeException {
    /**
     * Generated serial Version ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an expcetion with a specified message
     * @param message The String specified message when the exception is raised
     */
    public StackException(String message){
        super(message);
    }
}
