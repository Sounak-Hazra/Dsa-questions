public class FirstOccurence {
    static int firstOccurence(int arr[], int i,int num) {
        if (arr[i] == num) {
            return i;
        }
        if (i == arr.length - 1) {
            return -1;
        }

        return firstOccurence(arr, i + 1, num);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(firstOccurence(arr,0,3));
    }
}