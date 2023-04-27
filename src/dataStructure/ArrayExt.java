package dataStructure;

public class ArrayExt<E> extends ArrayClass<E> {

    @Override
    public void remove(E e) {
        int idx = searchIndexOf(e);
        removeAt(idx);
    }


}
