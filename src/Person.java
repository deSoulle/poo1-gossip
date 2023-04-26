public interface Person {


    String getName();
    String getType();
    void sendHome();
    boolean isHome();
    Landmark location();
    boolean hasGossips();
    boolean knowsGossip(Gossip gossip);
    void addGossip(Gossip gossip);
    boolean hasSecrets();
    void addSecret(Gossip secret);


}
