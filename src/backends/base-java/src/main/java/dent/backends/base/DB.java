package dent.backends.base;

import org.json.JSONException;
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

        //this.utils.debug("read " + jsonStr + " from " + this.path);
        try {
            return new JSONObject(jsonStr);
        } catch(JSONException e) {
            this.utils.error(jsonStr + e.getMessage());
            return json;
        }
    }

    public void load() {
        this.json = new JSONObject();
        try {
            this.f = new File(this.path);
            f.getParentFile().mkdirs();
            f.createNewFile();
            this.json = this.read(f);
        } catch (IOException e) {
            this.utils.error("db file not found (load)");
        }
    }

    public void dump() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(this.path);
            fw.write(json.toString());
            fw.close();
        } catch (IOException e) {
            this.utils.error("db file not found (dump)");
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
