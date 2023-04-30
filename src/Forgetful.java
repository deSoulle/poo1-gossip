
public class Forgetful extends PersonClass {
    private final int capacity;


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void addGossip(Gossip gossip) {
        if (!(gossips.size() == capacity)) {
            super.addGossip(gossip);
        }
        else {
            gossips.get(0).removeShare();

            if (gossips.get(0).getShares() == 0) {
                secrets.remove(gossips.get(0));
            }

            gossips.removeAt(0);
            super.addGossip(gossip);
        }
    }

    @Override
    public void shareGossips(Person other) {
        Gossip share = gossips.get(last++);
        if (!other.knowsGossip(share)) {
            other.addGossip(share);
        }
        if (last == gossips.size()) {
            last = 0;
        }

    }



}
