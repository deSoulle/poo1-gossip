import dataStructure.Array;
import dataStructure.ArrayExt;

public class Forgetful extends PersonClass {
    private final int capacity;
    private Array<Gossip> original;


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
        original = new ArrayExt<>();
        for (int i = 0; i < gossips.size(); i++) {
            original.insertLast(gossips.get(i));
        }
    }

    @Override
    public void addGossip(Gossip gossip) {
        if (!(gossips.size() == capacity)) {
            super.addGossip(gossip);
            original.insertLast(gossip);
        }
        else {
            original.get(0).removeShare();
            if ( original.get(0).getShares() == 0 ) { original.get(0).delete(); }
            gossips.remove(original.get(0));
            original.removeAt(0);
            super.addGossip(gossip);
            original.insertLast(gossip);
            oldest = gossips.searchIndexOf(original.get(0));
        }
    }

    @Override
    public void shareGossips(Person other) {
        super.shareGossips(other);
    }

    @Override
    public void resetOrder() {
        gossips = original;
    }


}
