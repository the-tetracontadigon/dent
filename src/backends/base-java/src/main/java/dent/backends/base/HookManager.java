package dent.backends.base;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import dent.backends.base.Query;
import dent.backends.base.Hook;
import dent.backends.base.Utils;
import net.minecraft.client.MinecraftClient;

public class HookManager {

    public ArrayList<Hook> hooks;
    private Query q;
    private boolean shutdown;
    private Utils utils;

    private MinecraftClient mc;

    public HookManager(ArrayList<Hook> hooks) {
        this.hooks = hooks;
        this.mc = MinecraftClient.getInstance();
        this.shutdown = false;
        this.q = new Query();
        this.utils = new Utils();

        for(Hook h : hooks) {
            this.q.setHookValue(h.getName(), h.get());
        }
    }

    public Hook getHook(String name) {
        for(Hook h : this.hooks) {
            if(Objects.equals(h.getName(), name)) {
                return h;
            }
        }
        return null;
    }

    public void tick() {
        if(mc.player != null && mc.currentScreen == null) {
            for (Hook h : hooks) {
                this.q.setHookValue(h.getName(), h.get());
                this.utils.debug(h.getName() + " ticked!");
            }
        }
    }
}
