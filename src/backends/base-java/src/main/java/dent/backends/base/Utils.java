package dent.backends.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;

import java.util.ArrayList;
import java.util.Objects;
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

    public String entityToString(LivingEntity entity) {
        return entity.getEntityName() + " : " + entity.getPos().toString() + " : " + Float.toString(entity.getHealth()) + " : " + entity.getActiveItem().toString();
    }
}
