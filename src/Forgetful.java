public class Forgetful extends PersonClass {
    private int capacity;
    private String type = "forgetful";


    public Forgetful(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void addGossip(Gossip gossip) {
        if (!(super.gossips.size() == capacity)) {
            super.addGossip(gossip);
        }
        else {
            super.gossips.removeAt(0);
            super.addGossip(gossip);
        }
    }

}
