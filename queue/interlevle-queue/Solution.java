import java.util.*;

public class Solution {

    static void interLevel(Queue<Integer> qM) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <= qM.size() / 2; i++) {
            q.add(qM.remove());
        }
        while (!q.isEmpty()) {
            qM.add(q.remove());
            qM.add(qM.remove());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        interLevel(q);
        System.err.println(q);
    }
}