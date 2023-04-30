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
        shared.insertLast(gossips.get(last - 1));
        return shared.iterator();
    }

}

