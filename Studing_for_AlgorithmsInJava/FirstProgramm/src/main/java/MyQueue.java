import java.util.Iterator;

/**
 * Created by Western-Co on 12.03.2017.
 */
public class MyQueue<E> implements Iterable<E> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        E item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(E item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public E dequeue() {
        E item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
