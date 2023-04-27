public class Sealed extends PersonClass{

    private int oldest


    public Sealed(String name) {
        super(name, "sealed");
    }7

    @Override
    public void shareGossips(Person other) {
        other.addGossip(secrets.get(oldest));
    }

}

