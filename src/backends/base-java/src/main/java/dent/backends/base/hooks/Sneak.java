package dent.backends.base.hooks;

import net.minecraft.client.MinecraftClient;

import java.util.Objects;

public class Sneak extends dent.backends.base.Hook {
    private final MinecraftClient mc;

    public Sneak() {
        super("Sneak");
        this.mc = MinecraftClient.getInstance();
        this.value = "none";
    }

    @Override
    public void onGet() {
        if(mc.player != null && mc.currentScreen == null) {
            if(mc.player.isSneaking()) {
                this.value = "true";
                //mc.player.setSneaking(true);
            } else {
                this.value = "false";
            }
        }
    }

    @Override
    public String onSet(String value) {
        if(!Objects.equals(value, this.value) && Objects.equals(value, "true")) {
            assert mc.player != null;
            mc.player.setSneaking(true);
            return "true";
        }
        return "false";
    }
}
