class Solution {
    static int count = 0;
    public static void paths(int row,int column,int m,int n){
        if(row >= m || column >= n){
            return;
        }
        if(row == m-1 && column == n-1){
            count++;
            return;
        }
        paths(row+1,column,m,n);
        paths(row,column+1,m,n);
    }

    public static int uniquePaths(int m, int n) {
        paths(0, 0, m, n);
        return count;
    }

    public static void main(String args[]) {
        System.out.println(uniquePaths(3,2));
    }
}