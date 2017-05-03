import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
            
        int count = 0;
        int max = 0;
        int j = 0;
        HashMap hm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == null) {
                count++;
                hm.put(s.charAt(i), i);
            } else {
                j = (j < (int) hm.get(s.charAt(i))) ? (int) hm.get(s.charAt(i)) : j;
                count = i - j;
                hm.put(s.charAt(i), i);
            }
            if (count > max)
                max = count;
        }
        return max;
    }
}