import java.util.*;

class Solution {
    public static int maxArea(ArrayList<Integer> height) {
        int p1 = 0;
        int p2 = height.size() - 1;
        int val = 0;
        while (p1 < p2) {
            int cur = Math.min(height.get(p1), height.get(p2)) * (p2 - p1);
            if (cur >= val) {
                val = cur;
            }
            if (height.get(p2) < height.get(p1)) {
                p2 -= 1;
            } else {
                p1 += 1;
            }
        }
        return val;
    }

    public static void main(String[] args) {

        ArrayList<Integer> heightList = new ArrayList<>();
        // [1,8,2,3,4,5,7,86,4]

        heightList.add(1);
        heightList.add(8);
        heightList.add(2);
        heightList.add(3);
        heightList.add(4);
        heightList.add(5);
        heightList.add(7);
        heightList.add(86);
        heightList.add(4);

        int result = maxArea(heightList);

        System.out.println("The maximum area is: " + result);
    }
}
