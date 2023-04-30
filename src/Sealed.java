import dataStructure.*;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = gossips.get(last++);
        if (!other.knowsGossip(share) && share.isAbout(this)) {
            share.addShare();
            other.addGossip(share);
        }

        if (last == gossips.size()) {
            last = 0;
        }

    }


}

