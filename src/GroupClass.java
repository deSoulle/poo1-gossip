import dataStructure.*;

public class GroupClass implements Group{

    private Array<Person> people;


    public GroupClass(Person person){
        people = new ArrayClass<>(1);
        people.insertLast(person);
    }

    @Override
    public boolean hasPerson(Person person) {
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).equals(person)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void addPerson(Person person) {
        people.insertLast(person);
    }

    @Override
    public void remove(Person person) {
        int index = people.searchIndexOf(person);
        people.removeAt(index);
    }

    @Override
    public int counter() {
        return people.size();
    }
}
