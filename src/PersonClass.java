import dataStructure.*;

public abstract class PersonClass implements Person{

    private final String name;
    private Landmark location;
    public Array<Gossip> gossips;
    private int oldest = 0;
    private Array<Gossip> secrets;
    private boolean home;


    public PersonClass(String name) {
        this.name = name;
        secrets = new ArrayClass<>();
        gossips = new ArrayClass<>();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void sendHome() {
        home = true;
        location = null;
    }

    @Override
    public boolean isHome() {
        return home;
    }

    @Override
    public Landmark location() {
        return location;
    }

    @Override
    public boolean knowsGossip(Gossip gossip) {
        for(int i = 0; i < gossips.size(); i ++) {
            if(gossips.get(i).equals(gossip)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasGossips() {
        return gossips.size() > 0;
    }

    @Override
    public void addGossip(Gossip gossip) {
        gossips.insertLast(gossip);
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
