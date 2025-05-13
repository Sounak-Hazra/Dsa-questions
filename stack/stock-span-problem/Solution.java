import java.util.*;
public class Solution {

    static void calculateSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stocks.length; i++) {
            while (stocks[s.peek()] < stocks[i] && !s.isEmpty()) {
                s.pop();
            }
            if (!s.isEmpty()) {
                span[i] = i - s.peek();
            }
            else {
                span[i] = i + 1;
            }
            s.push(i);
        }
    }
    public static void main(String args[]) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];

        calculateSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
    }
}