package insertInHeap;
import java.util.*;

public class Solution {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        void add(int a) {
            arr.add(a);

            int childIndex = arr.size() - 1;
            int prentIndex = (childIndex - 1) / 2;

            while (prentIndex >= 0 && arr.get(childIndex) < arr.get(prentIndex)) {
                int temp = arr.get(childIndex);
                arr.set(childIndex, arr.get(prentIndex));
                arr.set(prentIndex, temp);

                childIndex = prentIndex;
                prentIndex = (childIndex - 1) / 2;
            }
        }

        void printHeap() {
            System.out.println("Heap: " + arr);
        }
    }

    public static void main(String args[]) {
        Heap heap = new Heap();

        int[] testData = { 50, 20, 30, 10, 60, 15 };

        for (int val : testData) {
            heap.add(val);
        }

        heap.printHeap();  // Should show a valid min-heap
    }
}
