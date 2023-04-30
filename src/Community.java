import dataStructure.*;

public interface Community {

    /**
     @param place name of the landmark;
     @return true if exists a landmark with the given name;
     */
    boolean hasLandmark(String place);

    /**
     * @param name name of the landmark
     * @param capacity capacity of the landmark;
     * creates a new landmark with given name and capacity;
     */
    void addLandmark(String name, int capacity);

    /**
     * @param name name of the person;
     * @return true if exists a person with given name;
     */
    boolean hasName(String name);

    /**
     * @param name name of the person;
     * @param type person-type;
     * @param capacity gossip capacity in case type is forgetful;
     * creates a new person of the specified type and capacity;
     */
    void addPerson(String name, String type, int capacity);

    /**
     * @param name name of the person;
     * @param place name of the landmark
     * @return true if the person is in the people array of the landmark;
     */
    boolean isInPlace(String name, String place);

    /**
     * @param name name of the person;
     * @param place name of the landmark;
     * adds person to the people array of the specified landmark;
     */
    void moveToLandmark(String name, String place);

    /**
     * @param place name of the landmark;
     * @return true if the number of people registerd at the landmark equals the capacity of the landmark;
     */
    boolean isCrowded(String place);

    /**
     * @param place name of the landmark;
     * @return true if the landmark has no person registered;
     */
    boolean isEmpty(String place);

    /**
     * @param name name of the person;
     * @return true of the person is at no landmark;
     * checks if variable location in PersonClass is null;
     */
    boolean isHome(String name);

    /**
     * @param name name of the person;
     * @return true if person is registered in a group by themselves;
     * checks if the person is the only one in the people array of the group;
     */
    boolean isIsolated(String name);

    /**
     * @param name name of the person;
     * moves the person to a solo group at the landmark;
     */
    void isolate(String name);

    /**
     * @param name1 name of the first person;
     * @param name2 name of the second person;
     * @return true if both persons are registered at the landmark;
     */
    boolean sameLandmark(String name1, String name2);

    /**
     * @param name1 name of the first person;
     * @param name2 name of the second person;
     * moves the first person to the second's group;
     */
    void addToGroup(String name1, String name2);

    /**
     * @param place name of the landmark;
     * @return number of groups at a landmark;
     */
    int getGroups(String place);

    /**
     * @param name name of the person;
     * @return name of the other group members of the specified person;
     */
    String getGroupies(String name);

    /**
     * @param name1 name of the first person;
     * @param name2 name of the second person;
     * @return true if both persons are in the same group;
     */
    boolean sameGroup(String name1, String name2);

    /**
     * @param source name of creator/author of the gossip;
     * @param targets name of the persons whose gossip is about;
     * @param gossip descriptions/body of the gossip;
     * @return true if all three parameters are equal to an active gossip;
     */
    boolean gossipExists(String source, Array<String> targets, String gossip);

    /**
     * @param author name of creator/author of the gossip;
     * @param targets name of the persons whose gossip is about;
     * @param gossip descriptions/body of the gossip
     * creates a new gossip. it's added to gossips lists but only @author knows about it;
     */
    void createGossip(String author, Array<String> targets, String gossip);

    /**
     * @param name name of the person;
     * @return true if the gossip is in the gossips array of the person;
     */
    boolean knowsGossips(String name);

    /**
     * @return true if there are active gossips;
     * checks if there are gossips in the gossips array. gossips in this array have to be known by at least one person;
     */
    boolean hasGossips();

    /**
     * @return true if gossip sharing has happened;
     */
    boolean hasSharedGossips();

    /**
     * @param name name of the person;
     * @return true if there are active gossips about the person;
     */
    boolean hasSecrets(String name);

    /**
     * @param name name of the person;
     * @return true if person's person-type is sealed and that person knows a gossip about themselves;
     */
    boolean isSealed(String name);

    /**
     * @param name name of the person;
     * adds gossips(number depends on the person's person-type) to the person's group members;
     */
    void shareGossips(String name);

    /**
     * @param name name of the person;
     * @return name of the landmark the person is registered at;
     */
    String getLocation(String name);

    /**
     * @param name name of the person;
     * nullifies the location of person;
     */
    void sendHome(String name);

    /**
     * @return number of the times the most shared gossip was shared
     */
    int getHighestShare();

    /**
     * @return iterator of the landmarks array;
     */
    Iterator<Landmark> landmarkIterator();

    /**
     * @param place name of the landmark;
     * @return iterator of the groups array at the landmark;
     */
    Iterator<Group> groupIterator(String place);

    /**
     * @return iterator of the people array;
     */
    Iterator<Person> peopleIterator();

    /**
     * @param name name of the person;
     * @return iterator of the last gossips shared by the person;
     */
    Iterator<Gossip> sharedGossipsIterator(String name);

    /**
     * @param name name of the person;
     * @return iterator of the secrets array of the person;
     */
    Iterator<Gossip> secretsIterator(String name);

    /**
     * @param name name of the  person;
     * @return iterator of the gossips array of the person;
     */
    Iterator<Gossip> gossipsIterator(String name);

    /**
     * @return iterator of the most shared gossips;
     */
    Iterator<Gossip> hottestIterator();

    Iterator<Person> groupOfPeople(String name);
}
