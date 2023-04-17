public interface Person {


    String getName();
    String getType();
    void home();
    boolean atHome();
    Landmark location();
    boolean isIsolated();
    boolean hasGossips();
    boolean knowsGossip();
    void addGossip(Gossip gossip);
    boolean hasSecrets();
    void addSecret(Gossip secret);


}
