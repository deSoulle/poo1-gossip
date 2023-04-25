public class Forgetful extends Users {
    private int capacity;
    public Forgetful(String name, int capacity) {
        super(name);

        this.capacity = capacity;
    }

    public void addGossip(String name) {
        if (!(super.gossips.size() == capacity)) {
            super.addGossip(name);
        }
        else {
            super.gossips.removeAt(0);
            super.addGossip(name);
        }
    }


}
