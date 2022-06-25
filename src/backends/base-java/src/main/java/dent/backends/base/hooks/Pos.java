package dent.backends.base.hooks;

import dent.backends.base.Hook;
import dent.backends.base.Query;
import dent.backends.base.BaseJava;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class Pos extends dent.backends.base.Hook {

    private String[] valueList = new String[2];

    private MinecraftClient mc;

    public Pos() {
        super("Pos");
        this.mc = MinecraftClient.getInstance();

        this.value = "(0.0,0.0,0.0)|back";

    }

    @Override
    public void onGet() {
        super.onGet();
        if(mc.player != null && mc.currentScreen == null) {
            this.value = mc.player.getPos().toString();
        }
    }

    @Override
    public String onSet(String value) {
        //super.onSet(value);
        //if(Math.abs(Double.parseDouble(this.value.replace("(", "").split(",")[0]) - Double.parseDouble(value.replace("(", "").split(",")[0])) > 0.5)
        this.valueList = value.replace("(", "").replace(")", "").split(",");

        if (mc.player != null) {
            mc.player.setPosition(new Vec3d(Double.parseDouble(this.valueList[0]), Double.parseDouble(this.valueList[1]), Double.parseDouble(this.valueList[2])));
        }

        return this.get();
    }
}
