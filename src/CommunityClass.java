import dataStructure.*;

public class CommunityClass implements Community{

    private Array<Landmark> landmarks;
    private Array<Person> people;


    public CommunityClass() {
        landmarks = new ArrayClass<>(1);
        people = new ArrayClass<>(1);

    }

    @Override
    public boolean hasLandmark(String place) {
        for(int i = 0; i < landmarks.size(); i ++) {
            Landmark landmark = landmarks.get(i);
            if(landmark.getName().equals(place)) {
                return true;
            }

        }
        return false;
    }

    private Landmark getLandmark(String place) {
        for (int i = 0; i < landmarks.size(); i++) {
            Landmark landmark = landmarks.get(i);
            if (landmark.getName().equals(place)) {
                return landmark;
            }

        }
        return null;
    }

    @Override
    public boolean hasName(String name) {
        for(int i = 0; i < people.size(); i ++) {
            Person person = people.get(i);
            if(person.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    private Person getPerson(String name) {
        for(int i = 0; i < people.size(); i ++) {
            Person person = people.get(i);
            if(person.getName().equals(name)) {
                return person;
            }

        }
        return null;
    }

    @Override
    public boolean isInPlace(String name, String place) {
        Person person = getPerson(name);
        String location = person.location().getName();
        return location.equals(place);
    }

    @Override
    public boolean isCrowded(String place) {
        Landmark landmark = getLandmark(place);
        return landmark.isFull();

    }

    @Override
    public boolean isEmpty(String place) {
        Landmark landmark = getLandmark(place);
        return landmark.isEmpty();
    }

    @Override
    public boolean isHome(String name) {
        Person person = getPerson(name);
        return person.atHome();
    }

    @Override
    public boolean isIsolated(String name) {
        return false;
    }

    @Override
    public boolean sameLandmark(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        return person1.location().equals(person2.location());
    }

    @Override
    public boolean sameGroup(String name1, String name2) {

    }

    @Override
    public boolean hasGossip(String source, String[] targets, String gossip) {
        return false;
    }

    @Override
    public boolean knowsGossips(String name) {
        return false;
    }

    @Override
    public boolean canGossip(String name) {
        return false;
    }

    @Override
    public boolean hasGossips() {
        return false;
    }

    @Override
    public boolean hasSharedGossips() {
        return false;
    }

    @Override
    public boolean hasSecrets(String name) {
        return false;
    }

    @Override
    public boolean isSealed(String name) {
        return false;
    }

    @Override
    public String getLocation(String name) {
        return null;
    }

    @Override
    public void sendHome(String name) {

    }

    @Override
    public Iterator<Person> peopleIterator() {
        return null;
    }

    @Override
    public Iterator<Landmark> landmarkIterator() {
        return null;
    }
}
