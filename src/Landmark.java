import dataStructure.Iterator;

public interface Landmark {

    String getName();

    void addToGroup(Person person1, Person person2);
    Group getGroup(Person person);
    boolean isFull();
    boolean isEmpty();
    boolean sameGroup(Person p1, Person p2);
    boolean isIsolated(Person person);
    void isolate(Person person);
    void removePerson(Person person);
    void addPerson(Person person);
    int getCapacity();
    int getOcupation();
    int getGroups();
    Iterator<Group> groupsIterator();

}
