import dataStructure.*;

public class Forgetful extends PersonClass {
    private int capacity;


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void addGossip(Gossip gossip) {
        if (!(super.gossips.size() == capacity)) {
            super.addGossip(gossip);
        }
        else {
            super.gossips.removeAt(0);
            super.addGossip(gossip);
        }
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = gossips.get(0);
        share.addShare();
        if (!other.knowsGossip(share)) {
            other.addGossip(share);
        }
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(0));
        return shared.iterator();
    }


}
