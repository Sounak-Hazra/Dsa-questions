import java.util.*;
public class Solution {
    static int[] nextGratter(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int res[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            //* Step - 1
            while (!s.isEmpty() && s.peek() < arr[i]) {
                s.pop();
            }

            //* Step - 2
            if (s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }

            //* Step - 3
            s.push(arr[i]);
        }
        return res;
    }
    public static void main(String args[]) {
        int arr[] = { 5, 4, 6, 8, 9, 11, 3 };
        int res[] = nextGratter(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}