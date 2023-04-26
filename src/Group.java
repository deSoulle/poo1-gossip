public interface Group {

    boolean hasPerson(Person person);
    void addPerson(Person person);
    void remove(Person person);

    int counter();
}
