
import dataStructure.*;

public class Forgetful extends PersonClass {

    private Array<Gossip> gossips;

    public Forgetful(String name, int capacity) {
        super(name);
        gossips = new ArrayClass<>(capacity);
    }


    @Override
    public String getType() {
        return null;
    }

    @Override
    public boolean knowsGossip() {
        return false;
    }
}
