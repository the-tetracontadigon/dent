package dent.backends.base;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private final static Logger LOGGER = Logger.getLogger("Dent");

    public void debug(String message) {
        System.out.println("[DEBUG]: " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
