public interface Gossip {
    Person getAuthor();
    boolean isInvolved(Person target);
    String getDescription();
    void share();
    int getShares();
}
