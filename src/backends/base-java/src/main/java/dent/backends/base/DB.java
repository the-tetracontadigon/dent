package dent.backends.base;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DB {

    protected String path;
    protected Utils utils;
    protected JSONObject json;

    private File f = null;

    public DB(String path) {
        this.path = path;
        this.utils = new Utils();
    }

    public JSONObject read(File f) throws FileNotFoundException {
        String jsonStr = "";
        if(f.canRead()) {
            Scanner s = new Scanner(f);
            while(s.hasNextLine()) {
                jsonStr = jsonStr.concat(s.nextLine());
            }
        }
        this.utils.debug("read " + jsonStr + " from " + this.path);
        return new JSONObject(jsonStr);
    }

    public void load() {
        this.json = new JSONObject();
        try {
            this.f = new File(this.path);
            if(!f.createNewFile()) {
                this.utils.error("file " + this.path + " already exists.");
            }
            this.json = this.read(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dump() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(this.path);
            fw.write(json.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) throws FileNotFoundException {
        this.json = this.read(this.f);
        return (String) this.json.get(key);
    }

    public void set(String key, String value) {
        this.json.put(key, value);
        this.dump();
    }

}
