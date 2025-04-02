import java.util.*;
public class Solution {
    
    static String reverse(String data,Stack<Character> s) {
        if (data == "") {
            return "";
        }
        s.push(data.charAt(data.length() - 1));
        return s.pop() + reverse(data.substring(0, data.length() - 1), s);
    }
    public static void main(String args[]) {
        Stack<Character> s = new Stack<>();
        System.out.println(reverse("abcd", s));
    }
}