/**
 * @author Afonso de Sousa, 65548;
 * @author Miguel Victorino, 6;
*/

import dataStructure.*;

import java.util.Scanner;



public class Main {

    /**
     * Strings constants to detect user inputs;
     */
    private static final String EXIT = "exit";
    private static final String HELP = "help";
    private static final String LANDMARK = "landmark";
    private static final String LANDMARKS = "landmarks";
    private static final String FORGETFUL = "forgetful";
    private static final String GOSSIPER = "gossiper";
    private static final String SEALED = "sealed";
    private static final String PEOPLE = "people";
    private static final String GO = "go";
    private static final String JOIN = "join";
    private static final String GROUPS = "groups";
    private static final String ISOLATE = "isolate";
    private static final String START = "start";
    private static final String GOSSIP = "gossip";
    private static final String SECRETS = "secrets";
    private static final String INFOTAINMENT = "infotainment";
    private static final String HOTTEST = "hottest";
    /**
     * Strings constants for system outputs.
     */
    private static final String HELP_LIST =
        """
                    landmark - adds a new landmark to the community
                    landmarks - displays the list of landmarks in the community
                    forgetful - adds a forgetful person to the community
                    gossiper - adds a gossiper person to the community
                    sealed - adds a sealed lips person to the community
                    people - lists all the persons in the community
                    go - moves a person to a landmark, or home
                    join - joins a person to a group
                    groups - lists the groups composition in a landmark
                    isolate - makes a person leave the current group, but not the landmark the person is currently on
                    start - starts a new gossip
                    gossip - share a gossip within the current group in the current landmark
                    secrets - lists the gossip about a particular person
                    infotainment - lists the gossips a particular person is aware of
                    hottest - lists the most shared gossip
                    help - shows the available commands
                    exit - terminates the execution of the program""";
    private static final String ERROR_CREATE_HOME = "Cannot create a landmark called home. You know, there is no place like home!";
    private static final String ERROR_HOME = "You must understand we have no surveillance tech at home! Privacy is our top concern!";
    private static final String DUPLICATED_GOSSIP = "Duplicate gossip!";
    /**
     * other auxiliary variables (to loop, etc);
     */
    private static boolean loop = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Community comm = new CommunityClass();

        do {
            run(input, comm);
        }
        while (loop);

        input.close();

    }

   /**
    * Method used to run the desired commands
    */
    public static void run(Scanner input, Community community) {
            String prompt = input.next().toLowerCase().trim();
            switch (prompt) {
                case EXIT -> {
                    System.out.println("Bye!");
                    loop = false;
                }
                case HELP -> System.out.println(HELP_LIST);
                case LANDMARK -> landmark(input, community);
                case LANDMARKS -> listLandmarks(community);
                case FORGETFUL -> forgetful(input, community);
                case GOSSIPER -> gossiper(input, community);
                case SEALED -> sealed(input, community);
                case PEOPLE -> listPeople(community);
                case GO -> go(input, community);
                case JOIN -> join(input, community);
                case GROUPS -> groups(input, community);
                case ISOLATE -> isolate(input, community);
                case START -> start(input, community);
                case GOSSIP -> gossip(input, community);
                case SECRETS -> secrets(input, community);
                case INFOTAINMENT -> infotainment(input, community);
                case HOTTEST -> hottest(community);
                default -> {
                    input.nextLine();
                    System.out.println("Unknown command. Type help to see available commands.");
                }
            }
    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new landmark to the community.
     */
    private static void landmark(Scanner input, Community community) {
        int capacity = input.nextInt();
        String name = input.nextLine().trim();

        if (capacity <= 0) {
            System.out.println("Invalid landmark capacity " + capacity + "!");
        }
        else if (name.equals("home")) {
            System.out.println(ERROR_CREATE_HOME);
        }
        else if (community.hasLandmark(name)) {
            System.out.println("Landmark " + name + " already exists!");
        }
        else {
            community.addLandmark(name, capacity);
            System.out.println(name + " added.");
        }

    }

    /**
     * @param community class system;
     * Lists all the landmarks in the community.
     */
    private static void listLandmarks(Community community) {
        Iterator<Landmark> it = community.landmarkIterator();
        if (!it.hasNext()) {
            System.out.println("This community does not have any landmarks yet!");
        }
        while(it.hasNext()) {
            Landmark landmark = it.next();
            printLandmarks(landmark);
        }
    }

    /**
     * @param landmark an object of the Landmark class;
     * Auxiliary method that prints the desired text.
     */
    private static void printLandmarks(Landmark landmark) {
        System.out.println(landmark.getName() + ": " + landmark.getCapacity() + " " + landmark.getOccupation() + ".");
    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new forgetful-type person.
     */
    private static void forgetful(Scanner input, Community community) {
        int capacity = input.nextInt();
        String name = input.nextLine().trim();

        if (capacity <= 0) {
            System.out.println("Invalid gossips capacity " + capacity + "!");
        }
        else if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name, FORGETFUL, capacity);
            System.out.println(name + " can only remember up to " +  capacity + " gossips.");
        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new gossiper-type person.
     */
    private static void gossiper(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name, GOSSIPER, 0);
            System.out.println(name + " is a gossiper.");
        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new sealed lips-type person.
     */
    private static void sealed(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name, SEALED, 0);
            System.out.println(name + " lips are sealed.");
        }

    }

    /**
     * @param community class system;
     * Lists all the people in the community.
     */
    private static void listPeople(Community community) {
       Iterator<Person> it = community.peopleIterator();
        if (!it.hasNext()) {
            System.out.println("This community does not have any people yet!");
        }
        else {
            while (it.hasNext()) {
                Person person = it.next();
                printPeople(person);
            }
        }
    }

    /**
     * @param person object of the Person class;
     * Auxiliary method that prints the desired text.
     */
    private static void printPeople(Person person) {
        String location;
        if(person.location() == null) {
            location = "home";
        }
        else {
            location = person.location().getName();
        }
        System.out.println(person.getName() + " at " + location + " knows " + person.gossipsSize() + " gossips.");
    }

    /**
     * @param input user input;
     * @param community Object of the system class;
     * Moves a person to a landmark.
     */
    private static void go(Scanner input, Community community) {
        String name = input.nextLine().trim();
        String landmark = input.nextLine().trim();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exists!");
        }
        else if (!community.hasLandmark(landmark) || landmark.equals("home")) {
            System.out.println("Unknown place " + landmark + "!");
        }
        else if (community.isInPlace(name, landmark)) {
            System.out.println("What do you mean go to " + landmark + "? " + name + " is already there!");
        }
        else if (community.isCrowded(landmark)) {
            community.sendHome(name);
            System.out.println(landmark + " is too crowded! " + name + " went home.");
        }
        else {
            community.moveToLandmark(name, landmark);
            System.out.println(name + " is now at " + landmark + ".");
        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * Joins a person to a group.
     */
    private static void join(Scanner input, Community community) {
        String name1 = input.nextLine().trim();
        String name2 = input.nextLine().trim();

        if (name1.equals(name2)) {
            System.out.println(name1 + " needs company from someone else!");
        }
        else if (!community.hasName(name1)) {
            System.out.println(name1 + " does not exist!");
        }
        else if (!community.hasName(name2)) {
            System.out.println(name2 + " does not exist!");
        }
        else if (community.isHome(name1)) {
            System.out.println(name1 + " is at home!");
        }
        else if (!community.sameLandmark(name1, name2)) {
            System.out.println(name2 + " is not in " + community.getLocation(name1) + "!");
        }
        else if (community.sameGroup(name1, name2)) {
            System.out.println(name1 + " and " + name2 + " are already in the same group!");
        }
        else {
            community.addToGroup(name1, name2);
            System.out.println(name1 + " joined " + community.getGroupies(name1) + "at the " + community.getLocation(name2) + ".");
        }

    }

    /**
     * @param input user input;
     * @param community system class
     * Lists the groups located at the desired landmark.
     */
    private static void groups(Scanner input, Community community) {
        String place = input.nextLine().trim();

        if (place.equals("home")) {
            System.out.println(ERROR_HOME);
        }
        else if (!community.hasLandmark(place)) {
            System.out.println(place + " does not exist!");
        }
        else if (community.isEmpty(place)) {
            System.out.println("Nobody is at " + place + ".");
        }
        else {
            listGroups(community, place);
        }

    }


    /**
     * @param community class system;
     * Lists all the groups at the specified landmark.
     */
    private static void listGroups(Community community, String place) {
        Iterator<Group> it = community.groupIterator(place);

        System.out.println(community.getGroups(place) +  " groups at " + place + ":");
        while (it.hasNext()) {
               System.out.println(it.next().listGroupies(null));
        }
    }


    /**
     * @param input user input;
     * @param community system class;
     * isolated a person from the groups at its landmark.
     */
    private static void isolate(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exist!");
        }
        else if (community.isHome(name)) {
            System.out.println(name + " is at home!");
        }
        else if (community.isIsolated(name)) {
            System.out.println(name + " is already alone!");
        }
        else {
            community.isolate(name);
            System.out.println(name + " is now alone at " + community.getLocation(name));
        }


    }

    /**
     * @param input user input;
     * @param community system class;
     * creates a new gossip.
     */
    private static void start(Scanner input, Community community) {
        String author = input.nextLine().trim();
        int n = input.nextInt();input.nextLine();

        Array<String> targets = new ArrayExt<>();
        for(int i = 0; i < n; i ++) {
            targets.insertLast(input.nextLine());
        }

        String gossip = input.nextLine();

        if(!community.hasName(author)) {
            System.out.println(author + " does not exist!");
        }
        else if (n <= 0) {
            System.out.println("Invalid number " + n + " of gossip targets!");


        }

        else {
            boolean targetsExist = true;
            for (int i = 0; i < n; i++) {
                if (!community.hasName(targets.get(i))) {
                    System.out.println(targets.get(i) + " does not exist!");
                    targetsExist = false;
                    break;
                }
            }
            if(targetsExist) {
                if (community.gossipExists(author, targets, gossip)) {
                    System.out.println(DUPLICATED_GOSSIP);
                }
                else {
                    community.createGossip(author, targets, gossip);
                    System.out.println("Have you heard about " + listTargets(targets) + "? " + gossip);
                }

            }

        }

    }

    /**
     * @param targets list of people involved in a target;
     * @return a String with all the names of involved people in a gossip;
     * auxiliary method that joins all the names of involved people in a String separated by commas;
     */
    private static String listTargets(Array<String> targets) {
        String list = "";
        list = list.concat(targets.get(0));
        for(int i = 1; i < targets.size(); i ++) {
            list = list.concat(", " + targets.get(i));
        }
        return list;
    }



    /**
     * @param input user input;
     * @param community system class;
     * checks if a certain can spread gossips it knows (if it knows any) and if so shares them.
     */
    private static void gossip(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exist!");
        }
        else if (community.isIsolated(name)) {
            System.out.println(name + " has nobody to gossip with right now!");
        }
        else if(!community.knowsGossips(name)) {
            System.out.println(name + " knows nothing!");
        }
        else if(community.hasAboutThem(name)) {
            System.out.println(name + " does not wish to gossip right now!");
        }
        else {
            community.shareGossips(name);
            System.out.println(name + " shared with " + community.getGroupies(name) + " some hot news!");
            listSharedGossips(community, name);
        }

    }

    /**
     * @param community system class;
     * @param name name of the person;
     * auxiliary method to iterate the last shared gossips by a person;
     */
    private static void listSharedGossips(Community community, String name) {
        Iterator<Gossip> it = community.sharedGossipsIterator(name);

        while(it.hasNext()) {
            System.out.println(it.next().getDescription());
        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * check if a person has secrets around about them and how many people know them.
     */
    private static void secrets(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (!community.hasName(name))
            System.out.println(name + " does not exist!");
        else if(!community.hasSecrets(name))
            System.out.println(name + " lives a very boring life!");
        else {
            System.out.println("Here's what we know about " + name + ":");
            listSecrets(community, name);
        }

    }

    /**
     * @param community system class;
     * @param name name of the person;
     * auxiliary method to iterate the gossips about a person (iterates the secrets array of the person);
     */
    private static void listSecrets(Community community, String name) {
        Iterator<Gossip> it = community.secretsIterator(name);
        while (it.hasNext()) {
            Gossip secret = it.next();
            System.out.println(secret.getShares() + " " + secret.getDescription());
        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * lists the gossips a person is aware of.
     */
    private static void infotainment(Scanner input, Community community) {
        String name = input.nextLine().trim();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exist!");
        }
        else if (!community.knowsGossips(name)) {
            System.out.println(name + " knows nothing!");
        }
        else {
            System.out.println(name+ " knows things:");
            listGossips(community, name);

        }

    }

    /**
     * @param community system class;
     * @param name of the specified person;
     * lists the gossips a person is aware of.
     */
    private static void listGossips(Community community, String name) {
        Iterator<Gossip> it = community.gossipsIterator(name);

        while (it.hasNext()) {
            System.out.println(it.next().getDescription());
        }
    }

    /**
     * @param community system class;
     *lists the most shared gossips;
     */
    private static void hottest(Community community) {

        if (!community.hasGossips()) {
            System.out.println("No gossips we are aware of!");
        } else if (!community.hasSharedGossips()) {
            System.out.println("No gossips were shared, yet!");
        } else {
            listHottest(community);
        }
    }

    /**
     * @param community system class;
     * lists the most shared gossips in the community.
     */
    private static void listHottest(Community community) {
        Iterator<Gossip> it = community.hottestIterator();

        System.out.println("The hottest gossips were shared " + community.getHighestShare() + " times!");

        while (it.hasNext()) {
            System.out.println(it.next().getDescription());
        }
    }


}