import java.util.*;
public class Solution {
    
    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int val = q.remove();
        reverse(q);
        q.add(val);
    }
    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}