import dataStructure.Array;
import dataStructure.ArrayClass;

public class PersonClass implements Person{

    private final String name;
    private final String type;
    private final int capacity;
    private Landmark location;
    private Array<Gossip> gossips;
    private int oldest = 0;
    private Array<Gossip> secrets;

    public PersonClass(String name, int capacity, String type) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        gossips = new ArrayClass<>(capacity);
        secrets = new ArrayClass<>(0);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void home() {

    }

    @Override
    public boolean atHome() {
        return location.getName().equals("home");
    }

    @Override
    public Landmark location() {
        return location;
    }

    @Override
    public boolean isIsolated() {

    }

    @Override
    public boolean knowsGossips() {
        return gossips.size() > 0;
    }

    @Override
    public void addGossip(Gossip gossip) {
        gossips.insertAt(gossip, oldest);
        oldest ++;
    }

    @Override
    public boolean hasSecrets() {
        return secrets.size() < 0;
    }

    @Override
    public void addSecret(Gossip secret) {
        secrets.insertLast(secret);
    }
}
