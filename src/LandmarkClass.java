import dataStructure.*;

public class LandmarkClass implements Landmark{

    private final String name;
    private final int capacity;
    private int counter;
    private Array<Group> groups;


    public LandmarkClass(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        counter = 0;
        groups = new ArrayExt<>();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addToGroup(Person person1, Person person2) {
        if (isIsolated(person1)) {
            groups.remove(getGroup(person1));
        }
        else {
            getGroup(person1).remove(person1);
        }
        Group group = getGroup(person2);
        group.addPerson(person1);
        if(person1 instanceof Sealed) {
            person1.resetLast();
        }

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
        return counter == 0;
    }

    @Override
    public boolean sameGroup(Person p1, Person p2) {
        Group group = getGroup(p1);
        return group.hasPerson(p2);
    }

    @Override
    public boolean isIsolated(Person person) {
        return getGroup(person).size() == 1;
    }

    @Override
    public void isolate(Person person) {
        Group group = getGroup(person);
        group.remove(person);
        groups.insertLast(new GroupClass(person));
    }

    @Override
    public void removePerson(Person person) {
        Group group = getGroup(person);
        group.remove(person);

        if(group.size() <= 0) {
           groups.remove(group);
        }

        counter --;
    }

    @Override
    public void addPerson(Person person) {
        groups.insertLast(new GroupClass(person));
        counter ++;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getOccupation() {
        return counter;
    }

    @Override
    public int getGroups() {
        return groups.size();
    }

    @Override
    public Iterator<Group> groupsIterator() {
        return groups.iterator();
    }

}
