public class Solution {
    int start = 0;
    int length;
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int len = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            getPalindrome(s, i, i);
            getPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + length);
    }
    
    public void getPalindrome(String s, int b, int e) {
        while (b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
            b--;
            e++;
        }
        if (length < e - b - 1) {
            start = b + 1;
            length = e - b - 1;
        }
    }
}