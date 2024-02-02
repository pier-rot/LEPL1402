import java.util.Iterator;

public class ADT_Iteration<E> implements Iterable<E> {
    E var;
    ADT_Iteration next;

    public static void main(String[] args) {
        Integer var = 32;
        ADT_Iteration<Integer> adt = new ADT_Iteration<>(var);
        //System.out.println(adt.var);
    }

    public ADT_Iteration(E var) {
        this.var = var;
        this.next = null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO: think about implementing an inner class
        return new adtIterator();
    }

    class adtIterator implements Iterator<E> {
        ADT_Iteration<E> s = ADT_Iteration.this;
        @Override
        public boolean hasNext() {
            return s.next != null;
        }

        @Override
        public E next() {
            E var = s.var;
            s = s.next;
            return var;
        }

    }

}
