public class Solution {
    
    public static void printPermutation(String str, String ans) {
        
        //base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //kam

        for (int i = 0; i < str.length(); i++) {
            printPermutation(str.substring(0, i)+str.substring(i+1), ans+str.charAt(i));
        }
    }
    public static void main(String args[]) {
        String str = "Sounak";
        printPermutation(str, "");
    }
}