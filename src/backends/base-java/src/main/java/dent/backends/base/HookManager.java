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
    private final Query q;
    private boolean shutdown;

    private final MinecraftClient mc;

    public HookManager(ArrayList<Hook> hooks) {
        this.hooks = hooks;
        this.mc = MinecraftClient.getInstance();
        this.q = new Query();
        Utils utils = new Utils();

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
        //if in game
        if(mc.player != null && mc.currentScreen == null) {
            for (Hook h : hooks) {
                String dbValue = this.q.getHookValue(h.getName());
                String lValue = h.get();

                //if async
                if(!Objects.equals(lValue, dbValue) ) {
                    //if db value is from frontend
                    if(Objects.equals(dbValue.split("\\|")[dbValue.split("\\|").length - 1], "front")) {
                        //set local value to db value - "|front"
                        h.set(dbValue.replace("|front", ""));
                    }
                    //lValue = h.get();

                    //System.out.println(Double.parseDouble(lValue.replace("(", "").split(",")[0]) - Double.parseDouble(dbValue.replace("(", "").split(",")[0]));

                    //update
                    this.q.setHookValue(h.getName(), lValue);
                }
            }
        }
    }
}
