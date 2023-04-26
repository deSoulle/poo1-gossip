import dataStructure.*;

public class CommunityClass implements Community{
    private static final String FORGETFUL = "forgetful";
    private static final String GOSSIPER = "gossiper";
    private static final String SEALED = "sealed";

    private Array<Landmark> landmarks;
    private Array<Person> people;
    private Array<Gossip> gossips;


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

    @Override
    public void addGossiper(String name) {

    }

    @Override
    public void addForgetful(String name, int capacity) {

    }

    @Override
    public void addSealed(String name) {

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
        return person.isHome();
    }

    @Override
    public boolean isIsolated(String name) {
        Person person = getPerson(name);
        return person.isIsolated();
    }

    @Override
    public boolean sameLandmark(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        return person1.location().equals(person2.location());
    }

    @Override
    public boolean sameGroup(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        Landmark landmark = person1.location();
        return  landmark.sameGroup(person1, person2);
    }

    @Override
    public boolean gossipExists(String source, String[] targets, String description) {

        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).knowsGossip(gossip)) {
                return true;
            }
        }
        sharing = false;
        return false;
    }

    @Override
    public boolean knowsGossips(String name) {
        Person person = getPerson(name);
        return person.hasGossips();
    }

    @Override
    public boolean hasGossips() {
        return gossips.size() > 0;
    }

    @Override
    public boolean hasSharedGossips() {
        return sharing;
    }

    @Override
    public boolean hasSecrets(String name) {
        Person person = getPerson(name);
        return person.hasSecrets();
    }

    @Override
    public boolean isSealed(String name) {
        Person person = getPerson(name);
        return person.getType().equals(SEALED);
    }

    @Override
    public String getLocation(String name) {
        Person person = getPerson(name);
        return person.location().getName();
    }

    @Override
    public void sendHome(String name) {
        Person person = getPerson(name);
        person.sendHome();
    }

    @Override
    public Iterator<Person> peopleIterator() {
        return people.iterator();
    }

    @Override
    public Iterator<Landmark> landmarkIterator() {
        return landmarks.iterator();
    }
}
