import dataStructure.*;

public class Forgetful extends PersonClass {
    private final int capacity;


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void addGossip(Gossip gossip) {
        if (!(gossips.size() == capacity)) {
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
        if (!other.knowsGossip(share)) {
            share.addShare();
            other.addGossip(share);
        }
        if (last == gossips.size()) {
            last = 0;
        }
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        int tmp = last - 1;
        if ( tmp < 0 ) { tmp = gossips.size() - 1; }
        shared.insertLast(gossips.get(last - 1));
        return shared.iterator();
    }


}
