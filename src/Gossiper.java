import dataStructure.*;

public class Gossiper extends PersonClass{


    public Gossiper(String name) {
        super(name);
    }


    @Override
    public void shareGossips(Person other) {
        int num = Math.min(gossips.size(), 3);

        for (int i = 0 ; i < num; i ++) {
            Gossip share = gossips.get(last);
            if (!other.knowsGossip(share)) {
                share.addShare();
                other.addGossip(share);
            }
            last++;
            if (last == gossips.size()) {
                last = 0;
            }
        }

    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        for(int i = 0; i < 3; i ++) {
            shared.insertLast(gossips.get(i));
        }
        return shared.iterator();
    }

}

