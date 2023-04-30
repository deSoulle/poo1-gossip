import dataStructure.*;

public interface Gossip {

    /**
     * @return description/body of the gossip;
     */
    String getDescription();

    /**
     * increments the share counter;
     */
    void addShare();

    /**
     * @return share counter;
     */
    int getShares();

    /**
     * @param name name of the creator/author of the gossip;
     * @param targets people whose gossip is about;
     * @param description description/body of the gossip;
     * @return true if the gossip has the same attributes as the parameters;
     */
    boolean isTheSame(Person name, Array<Person> targets, String description);

    /**
     * @param person person object;
     * @return true if the person is one the involved people in the gossip;
     */
    boolean isAbout(Person person);
}
