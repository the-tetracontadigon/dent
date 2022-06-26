package dent.backends.base.hooks;

import net.minecraft.client.MinecraftClient;

import java.util.Objects;

public class Sprint extends dent.backends.base.Hook {

    private final MinecraftClient mc;

    public Sprint() {
        super("Sprint");
        this.mc = MinecraftClient.getInstance();
        this.value = "none";
    }

    @Override
    public void onGet() {
        if(mc.player != null && mc.currentScreen == null) {
            if(mc.player.isSprinting()) {
                this.value = "true";
                mc.player.setSprinting(true);
            } else {
                this.value = "false";
            }
        }
    }

    @Override
    public String onSet(String value) {
        if(!Objects.equals(value, this.value) && Objects.equals(value, "true")) {
            assert mc.player != null;
            mc.player.setSprinting(true);
            return "true";
        }
        return "false";
    }
}
