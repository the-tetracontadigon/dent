package dent.backends.base.hooks;

import net.minecraft.client.MinecraftClient;

import java.util.Objects;

public class Swim extends dent.backends.base.Hook {
    private final MinecraftClient mc;

    public Swim() {
        super("Swim");
        this.mc = MinecraftClient.getInstance();
        this.value = "none";
    }

    @Override
    public void onGet() {
        if(mc.player != null && mc.currentScreen == null) {
            if(mc.player.isSwimming()) {
                this.value = "true";
                //mc.player.setSwimming(true);
            } else {
                this.value = "false";
            }
        }
    }

    @Override
    public String onSet(String value) {
        if(!Objects.equals(value, this.value) && Objects.equals(value, "true")) {
            assert mc.player != null;
            mc.player.setSwimming(true);
            return "true";
        }
        return "false";
    }
}
