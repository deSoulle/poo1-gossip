import dataStructure.Array;
import dataStructure.ArrayExt;

public class Forgetful extends PersonClass {

    //gossip capacity of the forgetful-type person;
    private final int capacity;

    //gossip array sorted from oldest to newest gossips;
    private Array<Gossip> original;


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
        original = new ArrayExt<>();
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
        for (int i = 0; i < gossips.size(); i++) {
            gossips.removeAt(i);
            gossips.insertAt(original.get(i), i);
        }
    }


}
