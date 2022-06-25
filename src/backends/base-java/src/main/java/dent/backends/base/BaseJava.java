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
    private ArrayList<Hook> hooks;
    public MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        hooks = new ArrayList<>();
        hooks.add(new GameInfo());
        hooks.add(new Pos());

        hm = new HookManager(hooks);

        ClientTickEvents.START_CLIENT_TICK.register((tick) -> {
            hm.tick();
        });

    }
}
