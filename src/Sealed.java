import dataStructure.*;

public class Sealed extends PersonClass{

    public Sealed(String name) {
        super(name);
    }

    @Override
    public void shareGossips(Person other) {
        super.shareGossips(other);
    }


}

