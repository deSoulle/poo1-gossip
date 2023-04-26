public class Sealed extends PersonClass{

    private final String type = "sealed";


    public Sealed(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return type;
    }

}

