package dent.backends.base.hooks;

import net.minecraft.client.MinecraftClient;

import java.util.Objects;

public class GameInfo extends dent.backends.base.Hook {

    private MinecraftClient mc;

    private String version;
    private String server;

    public GameInfo() {
        super("GameInfo");
        this.mc = MinecraftClient.getInstance();
        //           (version,server)
        this.value = "(none, none)";
    }

    @Override
    public void onGet() {
        super.onGet();
        //in game
        if(mc.player != null && mc.currentScreen == null && mc.world != null) {
            this.version = mc.getGameVersion();
            if(mc.isInSingleplayer()) {
                this.server = "singleplayer";
            } else {
                this.server = mc.world.getServer().getServerIp();
            }
        }
        this.value = "(" + this.version + ", " + this.server + ")";
    }
}
