public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
    }

    @Override
    public void shareGossips(Person other) {
        boolean shared = false;
        while (!shared) {
            Gossip share = gossips.get(0);
            if (!other.knowsGossip(share) && share.isAbout(this)) {
                other.addGossip(share);
                shared = true;
            }
            gossips.remove(share);
            gossips.insertLast(share);
            oldest--;
            if (oldest < 0) { oldest = gossips.size() - 1; }
            }
    }


}

