import dataStructure.*;

public interface Person {


    String getName();
    void sendHome();
    boolean isHome();
    Landmark location();
    void move(Landmark destination);
    boolean hasGossips();
    boolean knowsGossip(Gossip gossip);
    void addGossip(Gossip gossip);
    void shareGossips(Person other);
    boolean hasSecrets();
    int gossipsSize();
    void addSecret(Gossip secret);
    Iterator<Gossip> sharedIterator();
    Iterator<Gossip> secretIterator();
    Iterator<Gossip> gossipsIterator();
}
