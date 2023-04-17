import dataStructure.*;

public class Gossiper extends PersonClass{

    private final String type = "gossiper";
    private Array<Gossip> gossips;

    public Gossiper(String name) {
        super(name);
        gossips = new ArrayClass<>();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean knowsGossip() {
        return gossips.size() > 0;
    }
}