import dataStructure.*;

public class GroupClass implements Group{

    Array<Person> people;


    public GroupClass(Person person){
        people = new ArrayExt<>();
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
    public Person getPerson(int pos) {
        return people.get(pos);
    }

    @Override
    public int size() {
        return people.size();
    }
}
