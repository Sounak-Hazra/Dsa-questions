import java.util.*;

public class Solution {

    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();


        boolean isEmpty() {
            return s1.isEmpty();
        }

        void add(int data) {
            if (s1.isEmpty()) {
                s1.push(data);
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        int remove() {
            if (s1.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return s1.pop();
        }

        int peek() {
            if (s1.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        System.out.println(q.remove());
    }
}