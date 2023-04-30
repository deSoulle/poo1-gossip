import dataStructure.*;

public abstract class PersonClass implements Person{

    private final String name;
    private Landmark location;
    protected Array<Gossip> gossips;
    protected Array<Gossip> secrets;
    protected int last;


    public PersonClass(String name) {
        this.name = name;
        location = null;
        secrets = new ArrayExt<>();
        gossips = new ArrayExt<>();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sendHome() {
        location = null;
    }

    @Override
    public boolean isHome() {
        return location == null;
    }

    @Override
    public Landmark location() {
        return location;
    }

    @Override
    public void move(Landmark destination) {
        location = destination;
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
        gossip.addShare();
        gossips.insertLast(gossip);
        gossip.addPerson(this);
    }

    @Override
    public boolean hasSecrets() {
        return secrets.size() > 0;
    }

    @Override
    public int gossipsSize() {
        return gossips.size();
    }


    @Override
    public void resetLast() {
        last = 0;
    }

    @Override
    public void addSecrets(Gossip neo) {
        secrets.insertLast(neo);
    }

    @Override
    public Iterator<Gossip> secretIterator() {
        return secrets.iterator();
    }

    @Override
    public Iterator<Gossip> gossipsIterator() {
        return gossips.iterator();
    }

    @Override
    public void removeGossip(GossipClass gossip) {
        secrets.remove(gossip);
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        int tmp = last - 1;
        if ( tmp < 0 ) { tmp = gossips.size() - 1; }
        shared.insertLast(gossips.get(tmp));
        return shared.iterator();
    }

}
