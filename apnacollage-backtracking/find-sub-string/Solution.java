public class Solution {

    public static void subString(String st, String ans, int i) {
        if (i == st.length()) {
            System.err.println(ans);
            return;
        }

        subString(st, ans + st.charAt(i), i+1);
        subString(st, ans, i+1);
    }
    public static void main(String args[]) {
        subString("Sounak", "", 0);
    }
}