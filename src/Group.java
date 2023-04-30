public interface Group {

    /**
     * @param person person object;
     * @return true if the person is registered in the group;
     */
    boolean hasPerson(Person person);

    /**
     * @param person person object;
     * adds the person to the list of people registered in the group;
     */
    void addPerson(Person person);

    /**
     * @param person person object;
     * removes the person from the list of people registered in the group;
     */
    void remove(Person person);

    /**
     * @param pos index in the people array;
     * @return person object;
     * returns the person registered in the group using the index in the people array;
     */
    Person getPerson(int pos);

    /**
     * @param person person object;
     * @return String with the names of the other group members;
     * concatenates a String with the namnes of the other group members separated by commas;
     */
    String listGroupies(Person person);

    /**
     * @return the size of the group;
     */
    int size();
}
