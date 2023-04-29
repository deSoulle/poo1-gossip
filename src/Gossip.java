import dataStructure.*;

public interface Gossip {
    String getDescription();
    void addShare();
    int getShares();
    boolean isTheSame(Person name, Array<Person> targets, String description);
    boolean isAbout(Person person);
}
