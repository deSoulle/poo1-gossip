import dataStructure.*;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
    }

    @Override
    public void shareGossips(Person other) {
        boolean shared = false;
        while (!shared) {
            for (int i = 0; i < gossips.size(); i++) {
                Gossip share = gossips.get(i);
                if (!other.knowsGossip(share) && share.isAbout(this)) {
                    other.addGossip(share);
                }
                gossips.remove(share);
                gossips.insertLast(share);
                oldest--;
                if (oldest < 0) { oldest = gossips.size() - 1; }
            }
        }
    }


}

