import java.util.Scanner;

import dataStructure.*;

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
    private static final String HELP_LIST = "\"landmark - adds a new landmark to the community\\n\" +\n" +
            "                \"landmarks - displays the list of landmarks in the community\\n\" +\n" +
            "                \"forgetful - adds a forgetful person to the community\\n\" +\n" +
            "                \"gossiper - adds a gossiper person to the community\\n\" +\n" +
            "                \"sealed - adds a sealed lips person to the community\\n\" +\n" +
            "                \"people - lists all the persons in the community\\n\" +\n" +
            "                \"go - moves a person to a landmark, or home\\n\" +\n" +
            "                \"join - joins a person to a group\\n\" +\n" +
            "                \"groups - lists the groups composition in a landmark\\n\" +\n" +
            "                \"isolate - makes a person leave the current group, but not the landmark the person is currently on\\n\" +\n" +
            "                \"start - starts a new gossip\\n\" +\n" +
            "                \"gossip - share a gossip within the current group in the current landmark\\n\" +\n" +
            "                \"secrets - lists the gossip about a particular person\\n\" +\n" +
            "                \"infotainment - lists the gossips a particular person is aware of\\n\" +\n" +
            "                \"hottest - lists the most shared gossip\\n\" +\n" +
            "                \"help - shows the available commands\\n\" +\n" +
            "                \"exit - terminates the execution of the program\"";
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
            String prompt = input.next();
            switch (prompt) {
                case EXIT -> {
                    System.out.println("Bye!");
                    loop = false;
                    break;
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
                default -> System.out.println("Unknown command. Type help to see available commands.");
            }

            System.out.println();

    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new landmark to the community.
     */
    private static void landmark(Scanner input, Community community) {
        int capacity = input.nextInt();
        String name = input.next();

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

        }

    }

    /**
     * @param community class system;
     * Lists all the landmarks in the community.
     */
    private static void listLandmarks(Community community) {
        Iterator<Landmark> it = community.landmarkIterator();
        while(it.hasNext()) {
            Landmark landmark = it.next();

        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new forgetful-type person.
     */
    private static void forgetful(Scanner input, Community community) {
        int capacity = input.nextInt();
        String name = input.next();

        if (capacity <= 0) {
            System.out.println("Invalid gossips capacity " + capacity + "!");
        }
        else if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name,FORGETFUL, capacity);
        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new gossiper-type person.
     */
    private static void gossiper(Scanner input, Community community) {
        String name = input.next();

        if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name, GOSSIPER, 0);
        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * Adds a new sealed lips-type person.
     */
    private static void sealed(Scanner input, Community community) {
        String name = input.next();

        if (community.hasName(name)) {
            System.out.println(name + " already exists!");
        }
        else {
            community.addPerson(name, SEALED, 0);
        }

    }

    /**
     * @param community class system;
     * Lists all the people in the community.
     */
    private static void listPeople(Community community) {
        Iterator<Person> it = community.peopleIterator();
    }

    /**
     * @param input user input;
     * @param community Object of the system class;
     * Moves a person to a landmark.
     */
    private static void go(Scanner input, Community community) {
        String name = input.next(); input.nextLine();
        String landmark = input.next();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exists!");
        }
        else if (community.hasLandmark(landmark)) {
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
        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * Joins a person to a group.
     */
    private static void join(Scanner input, Community community) {
        String name1 = input.nextLine();
        String name2 = input.next();

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
            System.out.println(name1 + " is at home.");
        }
        else if (!community.sameLandmark(name1, name2)) {
            System.out.println(name2 + " is not in " + community.getLocation(name1) + "!");
        }
        else if (community.sameGroup(name1, name2)) {
            System.out.println(name1 + " and " + name2 + " are already in the same group!");
        }
        else {
            community.addToGroup(name1, name2);
        }

    }

    /**
     * @param input user input;
     * @param community system class
     * Lists the groups located at the desired landmark.
     */
    private static void groups(Scanner input, Community community) {
        String place = input.next();

        if (place.equals("home")) {
            System.out.println(ERROR_HOME);
        }
        else if (!community.hasLandmark(place)) {
            System.out.println(place + " does not exist!");
        }
        else if (community.isEmpty(place)) {
            System.out.println("Nobody is at " + place);
        }
        else {
            community.groupIterator(place);

        }
    }

    /**
     * @param input user input;
     * @param community system class;
     * isolated a person from the groups at its landmark.
     */
    private static void isolate(Scanner input, Community community) {
        String name = input.next();

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
        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * creates a new gossip.
     */
    private static void start(Scanner input, Community community) {
        String name = input.next();
        int n = input.nextInt(); input.nextLine();

        if (!community.hasName(name))  {
            System.out.println(name + " does not exist!");
        }
        else if (n <= 0) {
            System.out.println("Invalid number " + n + " of gossip targets!");
        }
        else {
            Array<String> targets = new ArrayClass<>();
            for (int i = 0; i < n; i++) {
                targets.insertLast(new String(input.nextLine()));
            }

            String gossip = input.nextLine();

            for (int i = 0; i < n; i++) {
                if (!community.hasName(targets.get(i))) {
                    System.out.println(targets.get(i) + " does not exist!");
                    break;
                }
            }

            if (community.gossipExists(name, targets, gossip)) {
                System.out.println(DUPLICATED_GOSSIP);
            }
            else {

            }

        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * checks if a certain can spread gossips it knows (if it knows any) and if so shares them.
     */

    private static void gossip(Scanner input, Community community) {
        String name = input.nextLine();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exist!");
        }
        else if (community.isIsolated(name)) {
            System.out.println(name + " has nobody to gossip with right now!");
        }
        else if(!community.knowsGossips(name)) {
            System.out.println(name + " knows nothing!");
        }
        else if(community.isSealed(name)) {
            System.out.println(name + " does not wish to gossip right now!");
        }
        else {

        }

    }

    /**
     * @param input user input;
     * @param community system class;
     * check if a person has secrets around about it.
     */
    private static void secrets(Scanner input, Community community) {
        String name = input.nextLine();

        if (!community.hasName(name))
            System.out.println(name + " does not exist!");
        else if(!community.hasSecrets(name))
            System.out.println(name + " lives a very boring life!");
        else {

        }

    }

    /**
     * @param input user input;
     * @param community system class;
     */
    private static void infotainment(Scanner input, Community community) {

        String name = input.nextLine();

        if (!community.hasName(name)) {
            System.out.println(name + " does not exist!");
        }
        else if (!community.knowsGossips(name)) {
            System.out.println(name + " knows nothing!");
        }
        else {
            System.out.println(name+ " knows things:");
        }

    }

    /**
     * @param community system class:
     *
     */
    private static void hottest(Community community) {

        if (!community.hasGossips()) {
            System.out.println("No gossips we are aware of!");
        }
        else if(!community.hasSharedGossips()) {
            System.out.println("No gossips were shared, yet!");
        }
        else {
            
        }

    }

}