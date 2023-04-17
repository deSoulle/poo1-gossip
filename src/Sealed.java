import dataStructure.Array;
import dataStructure.ArrayClass;

public class Sealed extends PersonClass{

    private final String type = "String";
    private Array<Gossip> gossip;


    public Sealed(String name) {
        super(name);
        gossip = new ArrayClass<>();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean knowsGossip() {
        return gossip.size() > 0;
    }


}