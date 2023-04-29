import dataStructure.*;

public class Forgetful extends PersonClass {
    private final int capacity;


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
        Gossip share = gossips.get(last++);
        share.addShare();
        if (!other.knowsGossip(share)) {
            other.addGossip(share);
        }
        if (last == gossips.size()) {
            last = 0;
        }
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(0));
        return shared.iterator();
    }


}
