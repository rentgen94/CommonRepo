import java.util.Iterator;

/**
 * Created by Western-Co on 12.03.2017.
 */
public class MyStack<E> implements Iterable<E>{
    private Node first;
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
    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public E pop() {
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public void show() {
        System.out.println();
        for (Node item = first; item != null ; item = item.next) {
            System.out.print(item.item + " ");
        }
        System.out.println();
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