import dataStructure.Array;
import dataStructure.ArrayClass;

public abstract class PersonClass implements Person{

    private final String name;
    private Landmark location;
    private Array<Gossip> gossips;
    private int oldest = 0;
    private Array<Gossip> secrets;

    public PersonClass(String name) {
        this.name = name;
        secrets = new ArrayClass<>();

    }

    @Override
    public String getName() {
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
    public boolean hasGossips() {
        return gossips.size() > 0;
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
