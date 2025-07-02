public class CheckSorted {

    static boolean checkSorted(int arr[], int start) {
        if (start == arr.length-1) {
            // return true;
            System.out.println("Array is sorted.");
            return true;
        }

        if (arr[start] > arr[start + 1]) {
            // return false;
            System.out.println("Array is not sorted.");
            return false;
        }

        return checkSorted(arr, start + 1);
    }

    public static void main(String args[]) {
        int arr[] = {1};
        checkSorted(arr, 0);
    }
}