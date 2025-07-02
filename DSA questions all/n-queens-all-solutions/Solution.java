public class Solution {

    static boolean isSafe(char arr[][], int row, int col) {
        //top
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        

        for (int i = row, j = col; i >= 0 && j <arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    static void nQueens(char arr[][], int row) {
        //base case
        if (row == arr.length) {
            printBoard(arr);
            return;
        }

        for (int column = 0; column < arr.length; column++) {
            if (isSafe(arr, row, column)) {
                arr[row][column] = 'Q';
                nQueens(arr, row + 1);
                arr[row][column] = '.';
            }
        }
    }

    static void printBoard(char arr[][]) {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        char arr[][] = new char[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }

        nQueens(arr, 0);
    }
}