import dataStructure.*;

public abstract class PersonClass implements Person{

    private final String name;
    private Landmark location;
    protected Array<Gossip> gossips;
    protected Array<Gossip> secrets;
    private boolean home;
    protected int last;


    public PersonClass(String name) {
        this.name = name;
        home = true;
        secrets = new ArrayExt<>();
        gossips = new ArrayExt<>();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sendHome() {
        if (!home) {
            location.removePerson(this);
        }
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
    public void move(Landmark destination) {
        location = destination;
        home = false;
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
    public int gossipsSize() {
        return gossips.size();
    }

    @Override
    public void addSecret(Gossip secret) {
        secrets.insertLast(secret);
    }

    @Override
    public Iterator<Gossip> secretIterator() {
        return secrets.iterator();
    }

    @Override
    public Iterator<Gossip> gossipsIterator() {
        return gossips.iterator();
    }
}
