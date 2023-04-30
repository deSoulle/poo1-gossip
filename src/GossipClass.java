import dataStructure.Array;
import dataStructure.ArrayExt;


public class GossipClass implements Gossip {

    //person who created the gossip
    private final Person author;
    //description/body of the gossip;
    private final String description;
    //number of times the gossip was shared;
    private int shares;
    //person array with the people involved in the gossip;
    private Array<Person> involved;
    //person array with the people that know the gossip;
    private Array<Person> active;

    public GossipClass(Person author, Array<Person> involved, String description) {
        this.author = author;
        this.involved = involved;
        this.description = description;
        shares = 0;
        active = new ArrayExt<>();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void addShare() {
        shares ++;
    }

    @Override
    public int getShares() {
        return shares;
    }

    @Override
    public boolean isTheSame(Person person, Array<Person> targets, String description) {
        return author.equals(person) && targetsAreEqual(targets) && description.equals(this.description);
    }

    @Override
    public boolean isAbout(Person person) {
        for(int i = 0; i < involved.size(); i ++ ){
            if(involved.get(i).equals(person)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getActive() {
        return active.size();
    }

    @Override
    public void addActive(Person person) {
        active.insertLast(person);
    }

    @Override
    public void removeActive(Person person) {
        active.remove(person);
        if(active.size() == 0) {
            shares = 0;
            for ( int i = 0; i < involved.size(); i++ ) {
                involved.get(i).removeSecret(this);
            }
        }
    }

    /**
     * @param targets person array of people involved in a gossip;
     * @return true if the array given has the same people involved as the gossip;
     */
    private boolean targetsAreEqual(Array<Person> targets) {
        if(targets.size() == involved.size()) {
            for (int i = 0; i < involved.size(); i++) {
                for (int j = 0; j < targets.size(); j++) {
                    if (involved.get(i).equals(targets.get(j))) {
                        break;
                    }
                    else if (j == targets.size() - 1) {
                        return false;
                    }

                }

            }
            return true;

        }
        else {
            return false;
        }
    }


}
