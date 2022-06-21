package dent.backends.base.hooks;

import dent.backends.base.Hook;
import dent.backends.base.Query;
import dent.backends.base.BaseJava;
import net.minecraft.client.MinecraftClient;

public class Pos extends dent.backends.base.Hook {

    private Query q;

    private double x;
    private double y;
    private double z;

    private MinecraftClient mc;

    public Pos() {
        super("Pos");
        this.mc = MinecraftClient.getInstance();
        this.q = new Query();
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.value = valueFormat();
    }

    @Override
    public void onGet() {
        super.onGet();
        if(mc.player != null && mc.currentScreen == null) {
            //System.out.println("SCREEN" + mc.currentScreen.toString());
            this.x = mc.player.getX();
            this.y = mc.player.getY();
            this.z = mc.player.getZ();
            this.value = valueFormat();
        }
    }

    private String valueFormat() {
        return "[" + x + "," + y + "," + z + "]";
    }

    private void valueUnformat(String formatted) {
        String unformatted = "";
        unformatted = formatted.replace(" ", "");
        unformatted = unformatted.replace("[", "");
        unformatted = unformatted.replace("]", "");
        char[] unformattedChar = unformatted.toCharArray();
        this.x = unformattedChar[0];
        this.y = unformattedChar[1];
        this.z = unformattedChar[2];
    }

    @Override
    public void onSet() {
        super.onSet();
        valueUnformat(this.value);
    }
}
