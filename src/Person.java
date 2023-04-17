public interface Person {


    String getName();
    String getType();
    void home();
    boolean atHome();
    Landmark location();
    boolean isIsolated();
    boolean knowsGossip();
    boolean knowsGossips();
    void addGossip(Gossip gossip);
    boolean hasSecrets();
    void addSecret(Gossip secret);


}
