import dataStructure.*;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
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
        if ( tmp < 0 ) { tmp = gossips.size() -1; }
        shared.insertLast(gossips.get(tmp));
        return shared.iterator();
    }

}

