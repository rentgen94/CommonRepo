import edu.princeton.cs.algs4.ST;

import java.util.*;

/**
 * Created by Western-Co on 27.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        MyStack<Integer> stack = new MyStack();
        MyQueue<Integer> queue = new MyQueue();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            queue.enqueue(a[i]);
        }
        MyStack<Integer> stack1 = new MyStack<>();
        while (!queue.isEmpty()) {
            stack1.push(queue.dequeue());
        }
        stack1.show();
        for (Integer item : stack1) {
            System.out.print(item + " ");
        }
        System.out.println();
        while (!stack1.isEmpty()) {
            queue.enqueue(stack1.pop());
        }
        for (Integer item : queue) {
            System.out.println(item);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
