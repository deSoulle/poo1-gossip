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
        people.remove(person);
    }

    @Override
    public Person getPerson(int pos) {
        return people.get(pos);
    }

    @Override
    public String listGroupies(Person person) {
        String list = "";
        for(int i = 0; i < people.size() - 1; i ++) {
            Person groupie = people.get(i);
            if(!groupie.equals(person)) {
              list = list.concat(groupie.getName() + ", ");
            }
        }
        Person groupie = people.get(people.size()-1);
        if(!groupie.equals(person)){
            list = list.concat(groupie.getName());
        }
        return list;
    }

    @Override
    public int size() {
        return people.size();
    }

}
