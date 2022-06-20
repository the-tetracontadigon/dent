package dent.backends.base;

import dent.backends.base.DB;
import dent.backends.base.Utils;

import java.io.FileNotFoundException;

public class Query {

    protected DB db;
    private final Utils utils;

    public Query() {
        this.db = new DB(System.getProperty("user.home") + "/.dent/db.db");
        db.load();
        this.utils = new Utils();
    }

    public String getHookValue(String name) {
        this.utils.debug("DB: GET " + name);
        try {
            return this.db.get(name);
        } catch (FileNotFoundException e) {
            this.utils.error(e.getMessage());
        }
        return null;
    }

    public void setHookValue(String name, String value) {
        this.utils.debug("DB: SET " + name + ", " + value);
        this.db.set(name, value);
    }
}
