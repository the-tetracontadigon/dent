package dent.backends.base;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.ArrayList;

import dent.backends.base.Hook;
import dent.backends.base.hooks.*;
import net.minecraft.client.MinecraftClient;

public class BaseJava implements ModInitializer {

    private HookManager hm;

    @Override
    public void onInitialize() {
        ArrayList<Hook> hooks = new ArrayList<>();
        hooks.add(new GameInfo());
        hooks.add(new Pos());
        hooks.add(new Sprint());
        hooks.add(new Sneak());
        hooks.add(new Swim());
        hooks.add(new Inventory());
        //hooks.add(new Facing());

        hm = new HookManager(hooks);

        ClientTickEvents.END_CLIENT_TICK.register((mc) -> hm.tick());

    }
}
