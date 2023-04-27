import dataStructure.*;

public class CommunityClass implements Community {
    private static final String FORGETFUL = "forgetful";
    private static final String GOSSIPER = "gossiper";
    private static final String SEALED = "sealed";

    Array<Landmark> landmarks;
    Array<Person> people;
    Array<Gossip> gossips;


    public CommunityClass() {
        landmarks = new ArrayExt<>();
        people = new ArrayExt<>();
        gossips = new ArrayExt<>();
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

    @Override
    public void addLandmark(String name, int capacity) {
        landmarks.insertLast(new LandmarkClass(name, capacity));
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
    public void addPerson(String name, String type, int cap) {
        switch (type) {
            case GOSSIPER -> people.insertLast(new Gossiper(name));
            case FORGETFUL -> people.insertLast(new Forgetful(name, cap));
            case SEALED -> people.insertLast(new Sealed(name));
        }
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
    public void moveToLandmark(String name, String place) {
        Person person = getPerson(name);
        Landmark strtPoint = person.location();
        Landmark destiny = getLandmark(place);

        strtPoint.removePerson(person);
        destiny.addPerson(person);
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
        Landmark landmark = person.location();
        return landmark.isIsolated(person);
    }

    @Override
    public void isolate(String name) {
        Person person = getPerson(name);
        Landmark landmark = person.location();
        landmark.isolate(person);
    }

    @Override
    public boolean sameLandmark(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        return person1.location().equals(person2.location());
    }

    @Override
    public void addToGroup(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        Landmark landmark = person2.location();

        landmark.addToGroup(person1, person2);

    }

    @Override
    public int getGroups(String place) {
        Landmark landmark = getLandmark(place);
        return landmark.getGroups();
    }

    @Override
    public String getGroupies(String name) {
        Person person = getPerson(name);
        Landmark landmark = person.location();
        Group group = landmark.getGroup(person);

        return group.listGroupies(person);
    }

    @Override
    public boolean sameGroup(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);

        Landmark landmark = person1.location();
        return  landmark.sameGroup(person1, person2);
    }

    @Override
    public boolean gossipExists(String source, Array<String> targets, String description) {
        return findGossipIdx(source, targets, description) >= 0;
    }

    @Override
    public void createGossip(String author, Array<String> targets, String gossip) {
        Person person = getPerson(author);
        Array<Person> involved = new ArrayExt<>();
        for(int i = 0; i < targets.size(); i ++) {
            involved.insertLast(getPerson(targets.get(i)));
        }
        Gossip neo = new GossipClass(person, involved, gossip);
        gossips.insertLast(neo);
        person.addGossip(neo);

        for(int i = 0; i < targets.size(); i ++) {
            involved.get(i).addSecret(neo);
        }

    }

    private int findGossipIdx(String name, Array<String> targets, String description)  {
        int idx = -1;
        for (int i = 0; i < gossips.size(); i++) {
            if (gossips.get(i).isTheSame(name, targets, description)) {
                idx = i;
            }
        }
        return idx;
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
        return hasShares();
    }

    private boolean hasShares() {
        for (int i = 0; i < gossips.size(); i++) {
            if (gossips.get(i).getShares() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasSecrets(String name) {
        Person person = getPerson(name);
        return person.hasSecrets();
    }

    @Override
    public boolean isSealed(String name) {
        Person person = getPerson(name);
        return person instanceof Sealed;
    }

    @Override
    public void shareGossips(String name) {
        Person person = getPerson(name);
        Landmark landmark = person.location();
        Group group = landmark.getGroup(person);

        for(int i = 0; i < group.size(); i ++) {
            Person target = group.getPerson(i);
            if(!target.equals(person)) {
                person.shareGossips(target);
            }
        }

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
    public String getHighestShare() {
        return null;
    }

    @Override
    public Iterator<Group> groupIterator(String place) {
        Landmark landmark = getLandmark(place);
        return landmark.groupsIterator();
    }

    @Override
    public Iterator<Person> peopleIterator() {
        return people.iterator();
    }

    @Override
    public Iterator<Landmark> landmarkIterator() {
        return landmarks.iterator();
    }

    @Override
    public Iterator<Gossip> sharedGossipsIterator(String name) {
        Person person = getPerson(name);
        return person.sharedIterator();
    }

    @Override
    public Iterator<Gossip> secretsIterator(String name) {
        Person person = getPerson(name);
        return person.secretIterator();
    }

    @Override
    public Iterator<Gossip> gossipsIterator(String name) {
        Person person = getPerson(name);
        return person.gossipsIterator();
    }

    @Override
    public Iterator<Gossip> hottestIterator() {
        Array<Gossip> hottest = findHottest();
        return hottest.iterator();
    }

    private Array<Gossip> findHottest() {
        Array<Gossip> hottests = new ArrayExt<>();
        int maxShares = 0;

        for (int i = 0; i < gossips.size(); i ++) {
            Gossip gossip = gossips.get(i);
            if(gossip.getShares() >= maxShares) {
                hottests = new ArrayExt<>();
                hottests.insertLast(gossip);
            }
        }
        return hottests;
    }
}
