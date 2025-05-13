import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int nextSmaller[] = new int[heights.length];
        int prevSmaller[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();

        // Calculate next smaller array
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            nextSmaller[i] = s.isEmpty() ? heights.length : s.peek();
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        // Calculate the previous smaller element
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            prevSmaller[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int currHeight = (nextSmaller[i] - prevSmaller[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currHeight);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights));
    }
}
