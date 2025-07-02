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
    
    static void printQueen(char arr[][]){
        for(int i = 0;i<arr.length;i++){
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean nqueen(char arr[][], int row) {
        if (row >= arr.length) {
            printQueen(arr);
            return true;
        }
        for (int column = 0; column < arr.length; column++) {
            if (isSafe(arr, row, column)) {
                arr[row][column] = 'Q';
                if (nqueen(arr, row + 1)) {
                    return true;
                }
                arr[row][column] = 'X';
            }
        }
        return false;
    }
    
    static int count = 0;
    public static void main(String args[]) {
        char arr[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }
        }
        System.out.println(nqueen(arr, 0));
    }
}