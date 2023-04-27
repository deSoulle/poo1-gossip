import dataStructure.*;

public interface Gossip {
    String getDescription();
    void addShare();
    int getShares();
    boolean isTheSame(String name, Array<String> targets, String description);
}
