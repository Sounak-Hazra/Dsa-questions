import java.util.*;

public class Solution {

    static void pushAtEnd(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int val = s.pop();
        pushAtEnd(s, data);
        s.push(val);

    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        pushAtEnd(s, 0);
        System.out.println(s);
    }
}