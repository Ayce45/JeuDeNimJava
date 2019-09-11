package fr.ayce.tp1;

public class MonException extends Exception {
    // constructeur de MonException
    public MonException(String message) {
        // appel au constructeur de Exception
        super (message);
    }
}