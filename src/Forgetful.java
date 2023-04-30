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
        if(gossips.size() == capacity) {
            Gossip lost = original.get(0);
            gossips.remove(lost);
            original.remove(lost);
            lost.removeActive(this);

        }
        original.insertLast(gossip);
        gossips.insertLast(gossip);
        gossip.addActive(this);

    }

    @Override
    public void resetOrder() {
        gossips = original;
    }


}
