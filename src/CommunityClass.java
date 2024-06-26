import dataStructure.Array;
import dataStructure.ArrayExt;
import dataStructure.Iterator;

public class CommunityClass implements Community {

    //auxiliary String constants
    private static final String FORGETFUL = "forgetful";
    private static final String GOSSIPER = "gossiper";
    private static final String SEALED = "sealed";

    // arrays storing all the landmarks, people and active gossips;
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

    /**
     * @param place name of the landmark;
     * @return landmark object with the specified name;
     */
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

    /**
     * @param name name of the person;
     * @return person object with the specified name;
     */
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
        Landmark landmark = getLandmark(place);
        Person person = getPerson(name);

        if(person.location() == null) {
            return false;
        }
        else {
            return person.location().equals(landmark);
        }
    }

    @Override
    public void moveToLandmark(String name, String place) {
        Person person = getPerson(name);
        Landmark destiny = getLandmark(place);

        if(person.isHome()) {
            person.move(destiny);
            destiny.addPerson(person);
        }
        else {
            Landmark strtPoint = person.location();
            person.move(destiny);
            strtPoint.removePerson(person);
            destiny.addPerson(person);
        }
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
        Person author = getPerson(source);

        Array<Person> ptargets = new ArrayExt<>();
        for(int i = 0; i < targets.size(); i ++) {
            ptargets.insertLast(getPerson(targets.get(i)));
        }

        return findGossipIdx(author, ptargets, description);
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

        for (int i = 0; i < involved.size(); i++) {
            involved.get(i).addSecrets(neo);
        }

    }

    /**
     * @param author name of the person who started the gossip;
     * @param targets name of the people involved;
     * @param description description/body of the gossip;
     * @return true if there's already an active gossip with the same parameters;
     */
    private boolean findGossipIdx(Person author, Array<Person> targets, String description)  {
        for (int i = 0; i < gossips.size(); i++) {
            if (gossips.get(i).isTheSame(author, targets, description)) {
                return true;
            }
        }
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
        return hasShares();
    }

    /**
     * @return true if at least one gossip was shared;
     * auxiliary method to check if any gossip has been shared;
     */
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
        if(person instanceof Sealed) {
            return !person.knowsSecrets();
        }
        else {
         return false;
        }
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
        if(!person.isHome()) {
            person.location().removePerson(person);
            person.sendHome();
        }
    }

    @Override
    public int getHighestShare() {
        int maxShares = 0;

        for (int i = 0; i < gossips.size(); i ++) {
            Gossip gossip = gossips.get(i);
            if(gossip.getShares() > maxShares) {
                maxShares = gossip.getShares();
            }
        }

        return maxShares;
    }

    @Override
    public Iterator<Landmark> landmarkIterator() {
        return landmarks.iterator();
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

    @Override
    public Iterator<Person> groupOfPeople(String name) {
        Person person = getPerson(name);
        return person.location().getGroup(person).peopleIterator();
    }


    /**
     * @return list of the most shared gossips;
     * auxiliary method to list the hottest gossips;
     */
    private Array<Gossip> findHottest() {
        Array<Gossip> hottest = new ArrayExt<>();
        int maxShares = 0;

        for (int i = 0; i < gossips.size(); i ++) {
            Gossip gossip1 = gossips.get(i);
            for (int j = i+1; j < gossips.size(); j++) {
                Gossip gossip2 = gossips.get(j);
                if (gossip1.getShares() < gossip2.getShares()) {
                    maxShares = gossip2.getShares();
                }
            }
            if (gossip1.getShares() >= maxShares) {
                hottest.insertLast(gossip1);
                maxShares = gossip1.getShares();
            }
        }
        return hottest;
    }
}
