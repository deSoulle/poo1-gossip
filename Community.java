public interface Community {

    boolean hasLandmark(String landmark);
    boolean hasName(String name);
    boolean isInPlace(String name, String landmark);
    boolean isCrowded(String landmark);
    boolean isEmpty(String landmark);
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
    String getLandmark(String name);
    void sendHome(String name);


}
