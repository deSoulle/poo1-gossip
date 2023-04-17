import dataStructure.*;

public class GroupClass implements Group{

    private Array<Person> groupie;


    public GroupClass(Person person){
        groupie = new ArrayClass<>(1);
        groupie.insertLast(person);
    }

    @Override
    public boolean hasPerson(Person person) {
        for(int i = 0; i < groupie.size(); i ++) {
            if(groupie.get(i).equals(person)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void addPerson(Person person) {
        groupie.insertLast(person);
    }
}
