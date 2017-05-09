public class Solution {
    public boolean isMatch(String s, String p) {
        // Base case
        if (s == null || p == null) return false;
        // Setup dp
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        // Deal with "*" case
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) dp[0][i + 1] = true; 
        }
        
        // Main iterations
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') { // Ignore this char*
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // Count this char once, multiple times or ignore
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}