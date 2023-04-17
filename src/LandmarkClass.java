import dataStructure.Array;

public class LandmarkClass implements  Landmark{

    private final String name;
    private final int capacity;
    private int counter;
    private Array<Group> groups;


    public LandmarkClass(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        counter = 0;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Group getGroup(Person person) {
        for(int i = 0; i < groups.size(); i ++) {
            Group group = groups.get(i);
            if(group.hasPerson(person)) {
                return group;
            }

        }
        return null;
    }


    @Override
    public boolean isFull() {
        return counter == capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean sameGroup(Person p1, Person p2) {
        Group group = getGroup(p1);
        return group.hasPerson(p2);
    }
}
