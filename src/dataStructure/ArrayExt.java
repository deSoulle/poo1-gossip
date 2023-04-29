package dataStructure;

public class ArrayExt<E> extends ArrayClass<E> {

    public void remove(E e) {
        int idx = super.searchIndexOf(e);
        super.removeAt(idx);
    }


}
