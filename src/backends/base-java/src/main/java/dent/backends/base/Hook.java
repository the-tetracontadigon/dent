package dent.backends.base;

import dent.backends.base.Utils;

public class Hook {

    protected String name;
    protected String value;
    protected Utils utils;
    public Hook(String name) {
        this.name = name;
        this.value = "";
        this.utils = new Utils();
    }

    public String getName() {
        return this.name;
    }

    public void onGet() {
    }

    public String get() {
        this.onGet();
        this.utils.debug(this.name + " GET: " + this.value);
        return this.value;
    }

    public void onSet() {

    }

    public void set(String value) {
        this.value = value;
        this.onSet();
        this.utils.debug(this.name + " SET: " + this.value);
    }
}
