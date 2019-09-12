package fr.ayce.tp1;

/**
 * The type Mon exception.
 */
public class MonException extends Exception {
    /**
     * Instantiates a new Mon exception.
     *
     * @param message the message
     */
// constructeur de MonException
    public MonException(String message) {
        // appel au constructeur de Exception
        super (message);
    }
}