import dataStructure.Iterator;

public interface Landmark {


    /**
     * @return name of the landmark;
     */
    String getName();

    /**
     * @param person1 name of the first person;
     * @param person2 name of the second person;
     * adds the first person to the second's group;
     */
    void addToGroup(Person person1, Person person2);

    /**
     * @param person person object;
     * @return the group which the person is registered at;
     */
    Group getGroup(Person person);

    /**
     * @return true if the number of people registered at the landmark equals its capacity;
     */
    boolean isFull();

    /**
     * @return true if there isn't anyone registered at the landmark;
     */
    boolean isEmpty();

    /**
     * @param person1 first person object;
     * @param person2 second person object;
     * @return true if both persons are registered in the same group;
     */
    boolean sameGroup(Person person1, Person person2);

    /**
     * @param person person object;
     * @return true if the person is registered in a group by themselves;
     */
    boolean isIsolated(Person person);

    /**
     * @param person person object;
     * moves the person to a solo group;
     */
    void isolate(Person person);

    /**
     * @param person person object;
     * removes the person from the registered people at the landmark;
     */
    void removePerson(Person person);

    /**
     * @param person person object;
     * adds the person to the registered people at the landmark;
     */
    void addPerson(Person person);

    /**
     * @return capacity of the landmark;
     */
    int getCapacity();

    /**
     * @return number of people registered at the landmark;
     */
    int getOccupation();

    /**
     * @return number of groups at the landmark;
     */
    int getGroups();

    /**
     * @return groups array iterator;
     */
    Iterator<Group> groupsIterator();

}
