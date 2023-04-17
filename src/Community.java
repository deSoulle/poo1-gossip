import dataStructure.Iterator;

public interface Community {

    boolean hasLandmark(String place);
    boolean hasName(String name);
    boolean isInPlace(String name, String place);
    boolean isCrowded(String place);
    boolean isEmpty(String place);
    boolean isHome(String name);
    boolean isIsolated(String name);
    boolean sameLandmark(String name1, String name2);
    boolean sameGroup(String name1, String name2);
    boolean hasGossip(String source, String[] targets, String gossip);
    boolean knowsGossips(String name);
    boolean canGossip(String name);
    boolean hasGossips();
    boolean hasSharedGossips();
    boolean hasSecrets(String name);
    boolean isSealed(String name);
    String getLocation(String name);
    void sendHome(String name);
    Iterator<Person> peopleIterator();
    Iterator<Landmark> landmarkIterator();



}
