package dent.backends.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File(System.getProperty("user.home") + "/.dent/hooks.db");
        System.out.println(f.getAbsolutePath());
        f.getParentFile().mkdirs();
        f.createNewFile();

        Scanner s = new Scanner(f);
        System.out.println(s.nextLine());

        FileWriter fw = new FileWriter(f);
        fw.write("{}");
        fw.close();

        s = new Scanner(f);
        System.out.println(s.nextLine());


    }
}