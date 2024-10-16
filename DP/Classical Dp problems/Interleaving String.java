Q:- https://leetcode.com/problems/interleaving-string/
***************************************************************************
  class Solution {
    Boolean[][] dp;
    boolean helper(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p3 == s3.length()) {
            return true;
        }

         if (dp[p1][p2] != null) { 
            return dp[p1][p2];
        }
        boolean matchesS1 = (p1 < s1.length()) && s3.charAt(p3) == s1.charAt(p1);
        boolean matchesS2 = (p2 < s2.length()) && s3.charAt(p3) == s2.charAt(p2);
        boolean ans = false;
        if (matchesS1 && matchesS2) {
            ans = helper(s1, s2, s3, p1, p2+1, p3+1) || helper(s1, s2, s3, p1+1, p2, p3+1);
        } else if (matchesS1) {
            ans = helper(s1, s2, s3, p1+1, p2, p3+1);
        } else if (matchesS2) {
            ans = helper(s1, s2, s3, p1, p2+1, p3+1);
        } else {
            return false;
        }
        dp[p1][p2] = ans;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1, s2, s3, 0, 0, 0);
    
    }
}
