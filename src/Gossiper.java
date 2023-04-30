import dataStructure.Array;
import dataStructure.ArrayExt;
import dataStructure.Iterator;

public class Gossiper extends PersonClass {


    public Gossiper(String name) {
        super(name);
    }


    @Override
    public void shareGossips(Person other) {
        int num = Math.min(gossips.size(), 3);

        for (int i = 0 ; i < num; i ++) {
            super.shareGossips(other);
        }

    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        int num = Math.min(gossips.size(), 3);
        int tmp = gossips.size() - num;

        for(int i = 0; i < num; i ++) {
            if (tmp < 0) { tmp = gossips.size() + tmp - i; }

            shared.insertLast(gossips.get(tmp ++));
        }

        return shared.iterator();
    }

}

