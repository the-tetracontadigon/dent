package dent.backends.base.hooks;

import dent.backends.base.Utils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory extends dent.backends.base.Hook {

    private MinecraftClient mc;
    private Utils utils;

    public Inventory() {
        super("Inventory");
        this.mc = MinecraftClient.getInstance();
        this.value = "none";
        this.utils = new Utils();
    }

    @Override
    public void onGet() {
        if(mc.player != null && (mc.currentScreen == null || mc.currentScreen instanceof InventoryScreen)) {
            ArrayList<String> valueList = new ArrayList<>();
            PlayerInventory inventory = mc.player.getInventory();
            for(int i = 0; i < inventory.size() - 1; i++) {
                if(!(Objects.equals(inventory.getStack(i).getName().getString(), "Air"))) {
                    valueList.add(inventory.getStack(i).getName().getString() + " : " + Integer.toString(inventory.getStack(i).getCount()) + " (" + Integer.toString(i) + ")");
                }
            }
            if(!(Objects.equals(inventory.offHand.get(0).getName().getString(), "Air"))) {
                valueList.add(inventory.offHand.get(0).getName().getString() + " : " + Integer.toString(inventory.offHand.get(0).getCount()) + " (" + Integer.toString(40) + ")");
            }
            this.value = valueList.toString();
        }
    }

    @Override
    public String onSet(String value) {
//        if(value != this.value && value == "true") {
//            mc.player.setSprinting(true);
//            return "true";
//        }
        return this.value;
    }
}
