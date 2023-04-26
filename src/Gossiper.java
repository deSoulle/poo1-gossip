public class Gossiper extends PersonClass{

    private final String type = "gossiper";


    public Gossiper(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return type;
    }


}

