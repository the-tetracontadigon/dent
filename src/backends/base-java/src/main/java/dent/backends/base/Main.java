package dent.backends.base;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vec3d vd = new Vec3d(1, 2, 3);

        System.out.println(vd.toString().replace("(", "").replace(")", "").split(",")[0]);
    }

}