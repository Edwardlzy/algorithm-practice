public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        if (s.length() <= 1) return true;
        
        // Case 1: length is odd
        if (s.length() % 2 == 1) {
            int mid = s.length() / 2;
            for (int i = 1; i <= mid; i++) {
                if (s.charAt(mid - i) != s.charAt(mid + i)) return false;
            }
        }
        
        // Case 2: length is even
        else {
            int r = s.length() / 2;
            int l = r - 1;
            if (s.charAt(r) != s.charAt(l)) return false;
            for (int i = 1; i + r < s.length(); i++) {
                if (s.charAt(r + i) != s.charAt(l - i)) return false;
            }
        }
        
        return true;
        
        // Generic approach
        // if (x<0 || (x!=0 && x%10==0)) return false;
        // int rev = 0;
        // while (x>rev){
        // 	rev = rev*10 + x%10;
        // 	x = x/10;
        // }
        // return (x==rev || x==rev/10);
    }
}