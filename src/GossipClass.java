import dataStructure.*;


public class GossipClass implements Gossip {

    private final Person author;
    private Array<Person> involved;
    private final String description;
    private int shares;
    private Array<Person> knows;

    public GossipClass(Person author, Array<Person> involved, String description) {
        this.author = author;
        this.involved = involved;
        this.description = description;
        shares = 0;
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
    public void removeShare() {
        shares--;
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
    public void addPerson(Person person) {
        knows.insertLast(person);
    }

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
