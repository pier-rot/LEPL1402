import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Recursive Stack is a stack (LIFO)
 * that is immutable.
 *
 * @param <E>
 */
public class RecursiveStack<E> implements Iterable<E> {

    final E e;
    final RecursiveStack<E> next;

    /**
     * Creates an empty stack
     */
    public RecursiveStack() {
        e = null;
        next = null;
    }

    /**
     * Create a stack with e on top and next as the next stack.
     * The next is unchanged.
     *
     * @param e    the element to put on top
     * @param next the following stack
     */
    private RecursiveStack(E e, RecursiveStack<E> next) {
        // TODO
        this.e = e;
        this.next = next;
    }

    /**
     * Creates and return a new stack with e on top and the
     * current stack at the bottom.
     * The current stack is unchanged.
     *
     * @param e the element to place on top
     * @return the new stack
     */
    public RecursiveStack<E> add(E e) {
        return new RecursiveStack<E>(e, this);
    }

    /**
     * Returns the element on top of the stack
     *
     * @return the element on top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E top() {
        // TODO
        if (e != null) return e;
        else {
            throw new EmptyStackException();
        }
    }

    /**
     * Return the stack with element on top removed.
     * The current stack is unchanged.
     *
     * @return the stack with the top element removed
     */
    public RecursiveStack<E> removeTop() {
        // TODO
        if (this.next != null) return new RecursiveStack<E>(this.next.e, this.next.next);
        else if (this.next == null && this.e != null) {
            return new RecursiveStack<E>();
        } else throw new EmptyStackException();
    }

    /**
     * Computes the number of elements in the stack
     *
     * @return the number of element in the stack
     */
    public int size() {
        int size = 0;
        RecursiveStack<E> stack = this;

        while (stack.e != null) {
            stack = stack.removeTop();
            size++;
        }

        return size;
    }

    /**
     * Reverse the stack.
     * The current stack is unchanged.
     *
     * @return a reversed version of the current stack (the top element becomes the bottom one)
     */
    public RecursiveStack<E> reverse() {
        // TODO
        RecursiveStack<E> og = this;
        RecursiveStack<E> rev = new RecursiveStack<E>();
        while (rev.size() != this.size()) {
            rev = rev.add(og.top());
            og = og.removeTop();
        }
        return rev;
    }

    /**
     * Creates a top-down iterator on the stack
     * The delete is not implemented
     *
     * @return the top-down iterator.
     */
    @Override
    public Iterator<E> iterator() {
        // TODO: think about implementing an inner class
        Iterator<E> ite = new Iterator<E>() {
            RecursiveStack<E> s = RecursiveStack.this;

            @Override
            public boolean hasNext() {
                return s.next != null;
            }

            @Override
            public E next() {
                E e = s.e;
                s = s.next;
                return e;
            }
        };
        return ite;
    }


}
