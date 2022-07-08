package dent.backends.base.hooks;

import dent.backends.base.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

import java.util.Objects;

public class Facing extends dent.backends.base.Hook {
    private final MinecraftClient mc;
    private Utils utils;

    public Facing() {
        super("Facing");
        this.mc = MinecraftClient.getInstance();
        this.value = "none";
        this.utils = new Utils();
    }

    @Override
    public void onGet() {
        if(mc.player != null && mc.currentScreen == null && mc.crosshairTarget != null) {
            if(mc.crosshairTarget.getType() == HitResult.Type.ENTITY) {
                Entity eTarget = ((EntityHitResult) mc.crosshairTarget).getEntity();
                if(eTarget.isAlive()) {
                    LivingEntity lTarget = ((LivingEntity) eTarget);
                    this.value = this.utils.entityToString(lTarget);
                }
            } else if(mc.crosshairTarget.getType() == HitResult.Type.BLOCK) {
                BlockHitResult bTarget = ((BlockHitResult) mc.crosshairTarget);
                this.value = bTarget.getPos().toString() + " : " + bTarget.getSide().toString();
            } else {
                this.value = "none";
            }
        }
    }

    @Override
    public String onSet(String value) {
        if(!Objects.equals(value, this.value) && Objects.equals(value, "true")) {
            assert mc.player != null;
            mc.player.setSneaking(true);
            return "true";
        }
        return "false";
    }
}
