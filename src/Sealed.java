import dataStructure.*;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
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
    public void addGossip(Gossip gossip) {
        if (gossip.isAbout(this)) {
            gossips.insertLast(gossip);
        }
    }


    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(last));
        return shared.iterator();
    }

}

