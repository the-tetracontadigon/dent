package dent.backends.base;

import net.fabricmc.api.ModInitializer;

import java.util.ArrayList;

public class BaseJava implements ModInitializer {

    @Override
    public void onInitialize() {

        HookManager hm = new HookManager(new ArrayList<>());
    }
}
