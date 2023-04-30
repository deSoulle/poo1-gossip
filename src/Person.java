import dataStructure.*;

public interface Person {

    /**
     * @return name of the person;
     */
    String getName();

    /**
     * nullifies the location of the person;
     */
    void sendHome();

    /**
     * @return checks if the location is null;
     */
    boolean isHome();

    /**
     * @return the landmark where the person is registered;
     */
    Landmark location();

    /**
     * @param destination new landmark location;
     * changes the location to the new landmark;
     */
    void move(Landmark destination);

    /**
     * @return true if the person knows any gossips;
     */
    boolean hasGossips();

    /**
     * @param gossip gossip object;
     * @return true if the person knows the specified gossip;
     */
    boolean knowsGossip(Gossip gossip);

    /**
     * @param gossip new gossip object;
     * adds the new gossip to the gossips array of the person;
     */
    void addGossip(Gossip gossip);

    /**
     * @param other other person object;
     * shares known gossips with the other person;
     */
    void shareGossips(Person other);

    /**
     * @return true if the are gossips in the secrets array;
     * these are gossips which involve the person but that the person may not know about;
     */
    boolean hasSecrets();

    /**
     * @return number of gossips known by the person;
     */
    int gossipsSize();

    /**
     * @param secret new gossip object;
     * adds a new gossip about the person to the secrets array;
     */
    void addSecrets(Gossip secret);

    /**
     * @param secret gossip object;
     * removes the gossip about the person to the secrets array;
     */
    void removeSecret(Gossip secret);

    /**
     * @return true if the person knows a gossip about themselves;
     */
    boolean knowsSecrets();

    /**
     * sets the gossips array to the order which the gossips were received;
     */
    void resetOrder();

    /**
     * @return gossip iterator;
     * makes an iterator of the last gossips shared;
     */
    Iterator<Gossip> sharedIterator();

    /**
     * @return secrets array iterator;
     */
    Iterator<Gossip> secretIterator();

    /**
     * @return gossips array iterator;
     */
    Iterator<Gossip> gossipsIterator();



}
