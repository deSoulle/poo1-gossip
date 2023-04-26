import dataStructure.Array;
import dataStructure.ArrayClass;

public interface Gossip {
    Person getAuthor();
    boolean isInvolved(Person target);
    String getDescription();
    void share();
    int getShares();
    boolean isTheSame(String name, Array<String> targets, String description);
}
