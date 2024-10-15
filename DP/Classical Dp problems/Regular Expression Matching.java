Q:- https://leetcode.com/problems/regular-expression-matching/
************************************************************************************
TC: O(m*n)
SC: O(m*n)
------------------------------------------------------------
  class Solution {
    public  boolean isMatch(String str, String ptn) {
        if (ptn.equals(".*")) return true;
        char[] s = str.toCharArray(), p = ptn.toCharArray();
        int m = s.length, n = p.length;
        
         // left to right, add '' at the beginning, so dp[i+1][j+1] means match s[0, j] vs p[0, j]
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for (int j = 0; j < n; j++) // fill i = 0
            dp[0][j+1] = p[j] == '*' && dp[0][j-1]; // "ab" vs "a*b*c*"
        
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++)
            if (p[j] == '*') 
                dp[i+1][j+1] = dp[i+1][j-1] || // use '*' as 0 char, check back j-1(j-2 in p)
                match(s[i], p[j-1]) && dp[i][j+1]; // use '*' to match 1 more char, i must match j-1, s[0,i-1] must match p[0,j-1]
            else dp[i+1][j+1] = match(s[i], p[j]) && dp[i][j]; // normal match

        return dp[m][n];
    }
    
    private boolean match(char a, char b) {
        return b == '.' || b == a;
    }
}

