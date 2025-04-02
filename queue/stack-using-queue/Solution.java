import java.util.*;
public class Solution {

    public static class Stack {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();


        boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        void push(int data) {
            if (!q1.isEmpty()) {
                q2.add(data);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            } else {
                q1.add(data);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        int pop() {
            if (q1.isEmpty()) {
                return q2.remove();
            }
            else {
                return q1.remove();
            }
        }

    }
    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}