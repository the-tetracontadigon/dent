package dent.backends.base.hooks;

import dent.backends.base.Hook;
import dent.backends.base.Query;

public class Pos extends dent.backends.base.Hook {

    private Query q;

    public Pos() {
        super("Pos");

        q = new Query();
        this.value = "[0,0,0]";
    }

    @Override
    public void onGet() {
        super.onGet();

    }

    @Override
    public void onSet() {
        super.onSet();

    }
}
