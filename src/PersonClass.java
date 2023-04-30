import dataStructure.Array;
import dataStructure.ArrayExt;
import dataStructure.Iterator;

public abstract class PersonClass implements Person{

    //name of the person
    private final String name;
    //landmark where the person is registered;
    private Landmark location;
    //gossips the person knows;
    protected Array<Gossip> gossips;
    //gossips that involve the person;
    protected Array<Gossip> secrets;
    //index in the gossips array of the oldest gossip;
    protected int oldest;


    public PersonClass(String name) {
        this.name = name;
        location = null;
        secrets = new ArrayExt<>();
        gossips = new ArrayExt<>();
        oldest = 0;
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
        gossip.addActive(this);
        if (oldest > 0 ) {
            gossips.insertAt(gossip, oldest);
            oldest++;
        }
        else {
            gossips.insertLast(gossip);
        }
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = gossips.get(0);
        share.addShare();

        if (!other.knowsGossip(share)) {
            other.addGossip(share);
        }
        gossips.removeAt(0);
        gossips.insertLast(share);
        oldest --;
        if (oldest < 0) {
            oldest = gossips.size() - 1;
        }
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
    public void addSecrets(Gossip neo) {
        secrets.insertLast(neo);
    }

    @Override
    public boolean knowsSecrets() {
        for (int i = 0; i < gossips.size(); i ++) {
            if(gossips.get(i).isAbout(this)) {
                return true;
            }
        }
        return false;
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
    public void removeSecret(Gossip gossip) {
        secrets.remove(gossip);
    }

    @Override
    public void resetOrder() {}

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(gossips.size()-1));
        return shared.iterator();
    }

}
