public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && (haystack.length() - i >= needle.length())) {
                if (match(haystack.substring(i), needle)) return i;
            }
        }
        return -1;
    }
    
    public boolean match(String haystack, String needle) {
        if (haystack.substring(0, needle.length()).equals(needle)) return true;
        else return false;
    }
}