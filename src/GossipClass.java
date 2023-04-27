import dataStructure.*;


public class GossipClass implements Gossip {

    private final Person author;
    Array<Person> involved;
    private final String description;
    private int shares;

    public GossipClass(Person author, Array<Person> involved, String description) {
        this.author = author;
        this.involved = involved;
        this.description = description;
        shares = 0;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void addShare() {
        shares ++;
    }

    @Override
    public int getShares() {
        return shares;
    }

    @Override
    public boolean isTheSame(String name, Array<String> targets, String description) {
        return author.equals(name) && involved.equals(targets) && description.equals(this.description);
    }
}
