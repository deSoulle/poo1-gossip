public interface Group {

    boolean hasPerson(Person person);
    void addPerson(Person person);
    void remove(Person person);
    Person getPerson(int pos);
    String listGroupies(Person person);
    int size();
}
