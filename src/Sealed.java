import dataStructure.Array;
import dataStructure.ArrayExt;
import dataStructure.Iterator;

public class Sealed extends PersonClass{

    private int oldest;


    public Sealed(String name) {
        super(name);
        oldest = 0;
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = secrets.get(oldest ++);
        share.addShare();
        if(!other.knowsGossip(share)) {
            other.addGossip(share);
        }
    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        shared.insertLast(gossips.get(oldest));
        return shared.iterator();
    }

}

