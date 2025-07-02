import java.util.*;
public class Solutiion {

    static boolean duplicateParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (!(s.charAt(i) == ')')) {
                st.push(s.charAt(i));
            } else {
                int count = 0;
                while (st.peek() != '(' && !s.isEmpty()) {
                    st.pop();
                    count++;
                }
                if (!s.isEmpty()) {
                    st.pop();
                }
                
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        String s = "((10 + 20))";
        System.out.println(duplicateParenthesis(s));
    }
}