import dataStructure.Array;
import dataStructure.Iterator;

public interface Community {

    boolean hasLandmark(String place);
    boolean hasName(String name);
    void addPerson(String name, String forgetful, int capacity);
    boolean isInPlace(String name, String place);
    void moveToLandmark(String name, String place);
    boolean isCrowded(String place);
    boolean isEmpty(String place);
    boolean isHome(String name);
    boolean isIsolated(String name);
    void isolate(String name);
    boolean sameLandmark(String name1, String name2);
    void addToGroup(String name1, String name2);
    boolean sameGroup(String name1, String name2);
    boolean gossipExists(String source, Array<String> targets, String gossip);
    void createGossip(String author, Array<String> targets, String gossip);
    boolean knowsGossips(String name);
    boolean hasGossips();
    boolean hasSharedGossips();
    boolean hasSecrets(String name);
    boolean isSealed(String name);
    void shareGossips(String name);
    String getLocation(String name);
    void sendHome(String name);
    void addLandmark(String name, int capacity);
    Iterator<Group> groupIterator(String place);
    Iterator<Person> peopleIterator();
    Iterator<Landmark> landmarkIterator();


}
