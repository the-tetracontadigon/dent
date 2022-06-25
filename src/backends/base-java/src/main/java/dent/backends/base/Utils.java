package dent.backends.base;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private final static Logger LOGGER = Logger.getLogger("Dent");
    public final boolean debug = true;

    public void debug(String message) {
        if(debug) {
            System.out.println("[DEBUG]: " + message);
        }
    }

    public void error(String message) {
        if(debug) {
            System.out.println("[ERROR]: " + message);
        }
    }
}
