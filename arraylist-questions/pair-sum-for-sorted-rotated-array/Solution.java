public class Solution {

    public static int[] twoSum(int arr[], int target) {
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                p2 = i;
                p1 = i + 1;
                break;
            }
        }
        
        while (!(p1 == p2)) {
            int curr = arr[p1] + arr[p2];
            if (curr == target) {
                int res[] = { p1, p2 };
                return res;
            } else if (curr < target) {
                p1 = (p1 + 1) % (arr.length - 1);
            } else {
                p2 = (p2 - 1) % (arr.length - 1);
            }
        }
        return new int[0];
    }
    public static void main(String args[]) {
        int arr[] = { 13, 15, 6, 7, 8, 9, 10 };
        int res[] = new int[2];
        res = twoSum(arr, 28);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}