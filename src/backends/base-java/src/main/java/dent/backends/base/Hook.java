package dent.backends.base;

import dent.backends.base.Utils;

import java.util.Objects;

public class Hook {

    protected String name;
    protected String value;
    protected Utils utils;

    protected String oldLocal;
    protected String oldDB;
    public Hook(String name) {
        this.name = name;
        this.value = "";
        this.utils = new Utils();
    }

    public String getName() {
        return this.name;
    }

    public void onGet() {}

    public String get() {
        this.onGet();
        this.utils.debug(this.name + " GET: " + this.value);
        return this.value;
    }

    public String onSet(String value) {
        return value;
    }

    public void set(String value) {
        //this.value = value;
        this.utils.debug(this.name + " SET: " + value);
        this.value = this.onSet(value);
    }
}
