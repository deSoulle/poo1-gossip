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
            last ++;
            if (last == gossips.size()) {
                last = 0;
            }
        }

    }

    @Override
    public Iterator<Gossip> sharedIterator() {
        Array<Gossip> shared = new ArrayExt<>();
        int num = Math.min(gossips.size(), 3);
        int tmp = last - 1;

        for(int i = 0; i < num; i ++) {
            shared.insertAt(gossips.get(tmp --), i);
            if (tmp < 0) { tmp = gossips.size() - 1; }
        }

        return shared.iterator();
    }

}

