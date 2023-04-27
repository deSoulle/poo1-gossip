import dataStructure.*;

public class Gossiper extends PersonClass{


    public Gossiper(String name) {
        super(name, "gossiper");
    }


    @Override
    public void shareGossips(Person other) {
        int num = Math.min(gossips.size(), 3);

        for (int i = 0; i < num; i ++) {
            Gossip share = gossips.get(i);
            share.addShare();
            if (!other.knowsGossip(share)) {
                other.addGossip(share);
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

