class Solution {
    public static String removeDuplicateLetters(String s) {
        boolean arr[] = new boolean[26];
        
        // Initialize all elements in arr to false
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
        
        // Mark characters present in the string
        for (int i = 0; i < s.length(); i++) {
            int characterIndex = s.charAt(i) - 'a';
            arr[characterIndex] = true;
        }
        
        // Build the resulting string in alphabetical order
        String alp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                alp += (char)(97 + i);
            }
        }
        
        return alp;
    }

    public static void main(String[] args) {
        String input = "cbacdcbc";
        String result = removeDuplicateLetters(input);
        System.out.println("Result: " + result);
    }
}
