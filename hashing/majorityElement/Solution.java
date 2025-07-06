import java.util.*;

class Solution {
    
    void mejorityElement(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        
        Set<Integer> s = hm.keySet();

        for (Integer i : s) {
            if (hm.get(i) > arr.length / 3) {
                System.out.println(i);
            }
        }
    }
    
    public static void main(String args[]) {
        Solution sol = new Solution();

        // Test case 1
        int[] test1 = {3, 2, 3};
        sol.mejorityElement(test1);

        // Test case 2
        // int[] test2 = {1, 2};
        // sol.mejorityElement(test2);

        // // Test case 3
        // int[] test3 = {1, 1, 1, 3, 3, 2, 2, 2};
        // sol.mejorityElement(test3);

        // // Test case 4
        // int[] test4 = {4, 4, 4, 4};
        // sol.mejorityElement(test4);

        // // Test case 5
        // int[] test5 = {1, 2, 3, 4, 5, 6};
        // sol.mejorityElement(test5);
    }
}
