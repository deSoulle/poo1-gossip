public interface Person {


    String getName();
    String getType();
    void sendHome();
    boolean isHome();
    Landmark location();
    boolean hasGossips();
    boolean knowsGossip(Gossip gossip);
    void addGossip(Gossip gossip);
    void shareGossips(Person other);
    boolean hasSecrets();
    int gossipsSize();
    void addSecret(Gossip secret);
}
