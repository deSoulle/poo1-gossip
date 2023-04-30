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
            if (share.isAbout(this)) {
                other.addGossip(share);
            }
        }

        if (last == gossips.size()) {
            last = 0;
        }

    }

    public void resetLast() {
        last = 0;
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(last));
        return shared.iterator();
    }

}

