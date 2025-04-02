public class Solution {


    static boolean isSafe(char arr[][], int row, int column) {
        for (int i = 0; i < row; i++) {
            if (arr[i][column] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row, j = column; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }

    static void nqueen(char arr[][], int row) {
        if (row >= arr.length) {
            count++;
            return;
        }
        for (int column = 0; column < arr.length; column++) {
            if (isSafe(arr, row, column)) {
                arr[row][column] = 'Q';
                nqueen(arr, row + 1);
                arr[row][column] = 'X';
            }
        }               
    }
    
    static int count = 0;
    public static void main(String args[]) {
        char arr[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }
        }

        nqueen(arr, 0);
        System.out.println(count);
    }
}