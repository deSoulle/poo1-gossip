package dataStructure;

public class ArrayExt<E> extends ArrayClass<E> {

    private static final int SIZE = 50;

    /**
     * O vector generico de elementos do tipo E.
     */
    private E[] elems;

    /**
     * O numero de elementos do array.
     */
    private int counter;

    /**
     * Construtor com dimensao por defeito.
     */
    public ArrayExt() {
        elems = (E[]) new Object[SIZE];
        counter = 0;
    }

    /**
     * Construtor com dimensao <code>dimention</code>.
     * @param dimention - dimensao inicial do array.
     */
    @SuppressWarnings("unchecked")
    public ArrayExt(int dimention) {
        elems = (E[]) new Object[dimention];
        counter = 0;
    }


    @Override
    public void remove(E e) {
        int idx = searchIndexOf(e);
        removeAt(idx);
    }

}
