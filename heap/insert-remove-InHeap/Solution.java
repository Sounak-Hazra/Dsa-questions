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

        void remove() {
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            hepify(0);

        }

        private void hepify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left >= arr.size() && right >= arr.size()) {
                return;
            }

            if (left >= arr.size()) {
                int min = Math.min(arr.get(i), arr.get(right));
                if (min == arr.get(right)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(right));
                    arr.set(right, temp);
                    hepify(right);
                } else {
                    return;
                }
            }

            else if (right >= arr.size()) {
                int min = Math.min(arr.get(i), arr.get(left));

                if (min == arr.get(left)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(left));
                    arr.set(left, temp);
                    hepify(left);
                } else {
                    return;
                }
            } else {
                int min = Math.min(arr.get(left), Math.min(arr.get(i), arr.get(right)));

                if (min == arr.get(left)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(left));
                    arr.set(left, temp);
                    hepify(left);
                } else if (min == arr.get(right)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(right));
                    arr.set(right, temp);
                    hepify(right);
                } else {
                    return;
                }
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

        heap.printHeap(); // Should show a valid min-heap

        heap.remove();

        heap.printHeap();
    }
}
