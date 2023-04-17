public interface Landmark {

    String getName();

    Group getGroup(Person person);

    boolean isFull();
    boolean isEmpty();
    boolean sameGroup(Person p1, Person p2);

}
