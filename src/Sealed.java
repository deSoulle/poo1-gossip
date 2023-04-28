import dataStructure.Array;
import dataStructure.ArrayExt;
import dataStructure.Iterator;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = secrets.get(last++);
        share.addShare();
        if(!other.knowsGossip(share)) {
            other.addGossip(share);
        }
        if (last == secrets.size()) {
            last = 0;
        }
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(last));
        return shared.iterator();
    }

}

