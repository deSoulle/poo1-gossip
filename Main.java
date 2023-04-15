import java.util.Scanner;
public class Main {

    /**
     * Constants used to get the name of the desired command.
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
     *
     */
    private static final String ERROR_CREATE_HOME = "Cannot create a landmark called home. You know, there is no place like home!";
    private static final String ERROR_HOME = "You must understand we have no surveillance tech at home! Privacy is our top concern!";
    private static final String DUPLICATED_GOSSIP = "Duplicate gossip!";
    public static void main(String[] args) {



    }

   /**
    * Method used to run the desired commands
    */
    public void run() {

        Scanner in = new Scanner(System.in);

        GossipSystem system = new GossipSystem();
        boolean cond = true;

        while(cond) {
            String option = in.next();
            switch (option) {
                case EXIT:
                    exit(in);
                    break;
                case HELP:
                    help();
                    break;
                case LANDMARK:
                    landmark(in, system);
                    break;
                case LANDMARKS:
                    landmarks(system);
                    break;
                case FORGETFUL:
                    forgetful(in, system);
                    break;
                case GOSSIPER:
                    gossiper(in, system);
                    break;
                case SEALED:
                    sealed(in, system);
                    break;
                case PEOPLE:
                    people(system);
                    break;
                case GO:
                    go(in, system);
                    break;
                case JOIN:
                    join(in, system);
                    break;
                case GROUPS:
                    groups(in, system);
                    break;
                case ISOLATE:
                    isolate(in, system);
                    break;
                case START:
                    start(in, system);
                    break;
                case GOSSIP:
                    gossip(in, system);
                    break;
                case SECRETS:
                    secrets(in, system);
                    break;
                case INFOTAINMENT:
                    infotainment(in, system);
                    break;
                case HOTTEST:
                    hottest(system);
                    break;
                default:
                    System.out.println("Unknown command. Type help to see available commands.");
            }

            System.out.println();

        }

    }

    private void hottest(GossipSystem system) {

        if (!system.hasGossips())
            System.out.println("No gossips we are aware of!");
        else if(!system.hasSharedGossips())
            System.out.println("No gossips were shared, yet!");
        else {
            
        }

    }

    private void infotainment(Scanner in, GossipSystem system) {

        String name = in.nextLine();

        if (!system.hasName(name))
            System.out.println(name + " does not exist!");
        else if (!system.knowsGossips(name))
            System.out.println(name + " knows nothing!");
        else {

            System.out.println(name+ " knows things:");

        }

    }

    private void secrets(Scanner in, GossipSystem system) {

        String name = in.nextLine();

        if (!system.hasName(name))
            System.out.println(name + " does not exist!");
        else if(!system.hasSecrets(name))
            System.out.println(name + " lives a very boring life!");
        else {

        }

    }

    private void gossip(Scanner in, GossipSystem system) {

        String name = in.nextLine();

        if (!system.hasName(name))
            System.out.println(name + " does not exist!");
        else if (system.isIsolated(name))
            System.out.println(name + " has nobody to gossip with right now!");
        else if(!system.canGossip(name))
            System.out.println(name + " knows nothing!");
        else if(system.isSealed)
            System.out.println(name + " does not wish to gossip right now!");
        else {

        }

    }

    private void start(Scanner in, GossipSystem system) {

        String name = in.next();
        int n = in.nextInt(); in.nextLine();

        String[] people = new String[n];

        for (int i = 0; i < n; i++)
            people[i] = in.nextLine();

        String gossip = in.nextLine();

        if (!system.hasName(name))
            System.out.println(name + " does not exist!");
        else if (n <= 0)
            System.out.println("Invalid number " + n + " of gossip targets!");
        else
            for (int i = 0; i < n; i++)
                if (system.hasName(people[i])) {
                    System.out.println(people[i] + " does not exist!");
                    i = n;
                }
        else if (system.hasGossip(name, people, gossip))
            System.out.println(DUPLICATED_GOSSIP);
        else {

        }

    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Makes a person leave the current group, but not the landmark the person is currently on.
     */
    private void isolate(Scanner in, GossipSystem system) {

        String name = in.next();

        if (!system.hasName(name))
            System.out.println(name + " does not exist!");
        else if (system.isHome(name))
            System.out.println(name + " is at home!");
        else if (system.isIsolated(name))
            System.out.println(name + " is already alone!");
        else {

        }
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Lists the groups composition of the desired landmark.
     */
    private void groups(Scanner in, GossipSystem system) {

        String place = in.next();

        if (place.equals("home"))
            System.out.println(ERROR_HOME);
        else if (!system.hasLandmark(place))
            System.out.println(place + " does not exist!");
        else if (system.isEmpty(place))
            System.out.println("Nobody is at " + place);
        else {

        }
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Joins a person to a group.
     */
    private void join(Scanner in, GossipSystem system) {

        String name1 = in.next(); in.nextLine();
        String name2 = in.next();

        if (name1.equals(name2))
            System.out.println(name1 + " needs company from someone else!");
        else if (!system.hasName(name1))
            System.out.println(name1 + " does not exist!");
        else if (!system.hasName(name2))
            System.out.println(name2 + " does not exist!");
        else if (system.isHome(name1))
            System.out.println(name1 " is at home.");
        else if (!system.sameLandmark(name1, name2))
            System.out.println(name2 + " is not in " + system.getLandmark(name1) + "!");
        else if (system.sameGroup(name1, name2))
            System.out.println(name1 + " and " + name2 + " are already in the same group!");
        else {

        }
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Moves a person to a landmark.
     */
    private void go(Scanner in, GossipSystem system) {

        String name = in.next(); in.nextLine();
        String place = in.next();

        if (!system.hasName(name))
            System.out.println(name + " does not exists!");
        else if (system.hasLandmark(place))
            System.out.println("Unknown place " + place + "!");
        else if (system.isInPlace(name, place))
            System.out.println("What do you mean go to " + place + "? " + name + " is already there!");
        else if (system.isCrowded(place)) {
            system.goHome(name);
            System.out.println( place + " is too crowded! " + name + " went home.");
        }
        else {

        }
    }

    /**
     * @param system Object of the system class
     * Lists all the people in the comunity.
     */
    private void people(GossipSystem system) {
        
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Adds a new sealed person.
     */
    private void sealed(Scanner in, GossipSystem system) {

        String name = in.next();

        if (system.hasName())
            System.out.println(name + " already exists!");
        else {
            
        }
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Adds a new gossiper person.
     */
    private void gossiper(Scanner in, GossipSystem system) {

        String name = in.next();

        if (system.hasName())
            System.out.println(name + " already exists!");
        else {

        }
    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Adds a new forgetful person.
     */
    private void forgetful(Scanner in, GossipSystem system) {

        int capacity = in.nextInt();
        String name = in.next();

        if (capacity <= 0)
            System.out.println("Invalid gossips capacity " + capacity + "!");
        else if (system.hasName(name))
            System.out.println(name + " already exists!");
        else {

        }
    }

    /**
     * @param system Object of system class
     * Lists all existing landmarks.
     */
    private void landmarks(GossipSystem system) {


    }

    /**
     * @param in User input
     * @param system Object of the system class
     * Adds a new landmark to the community.
     */
    private void landmark(Scanner in, GossipSystem system) {

        int capacity = in.nextInt();
        String name = in.next();

        if (capacity <= 0)
            System.out.println("Invalid landmark capacity " + capacity + "!");
        else if (name.equals("home"))
            System.out.println(ERROR_CREATE_HOME);
        else if (system.hasLandmark(name))
            System.out.println("Landmark " + name + " already exists!");
        else {

        }
    }

    /**
     * Shows all the available commands.
     */
    private void help() {
        System.out.println("landmark - adds a new landmark to the community\n" +
                "landmarks - displays the list of landmarks in the community\n" +
                "forgetful - adds a forgetful person to the community\n" +
                "gossiper - adds a gossiper person to the community\n" +
                "sealed - adds a sealed lips person to the community\n" +
                "people - lists all the persons in the community\n" +
                "go - moves a person to a landmark, or home\n" +
                "join - joins a person to a group\n" +
                "groups - lists the groups composition in a landmark\n" +
                "isolate - makes a person leave the current group, but not the landmark the person is currently on\n" +
                "start - starts a new gossip\n" +
                "gossip - share a gossip within the current group in the current landmark\n" +
                "secrets - lists the gossip about a particular person\n" +
                "infotainment - lists the gossips a particular person is aware of\n" +
                "hottest - lists the most shared gossip\n" +
                "help - shows the available commands\n" +
                "exit - terminates the execution of the program");
    }

    /**
     * @param in: User input
     * Exits the console.
     */
    private void exit(Scanner in) {
        System.out.println("Bye!");
        in.close();
    }
}