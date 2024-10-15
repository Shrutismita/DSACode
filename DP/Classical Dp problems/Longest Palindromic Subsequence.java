Q:- https://leetcode.com/problems/longest-palindromic-subsequence/
**********************************************************************************************
//Approach-1 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
----------------------------------------------------------
  class Solution {
     int[][] dp ;
      public int LPS(String s, int i, int j) 
      {
        if( i > j)
             return 0;
        if(i == j)     
              return 1;

         if(dp[i][j] != -1)
              return dp[i][j];

          if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = 2 + LPS(s, i + 1, j - 1);
        else
            return dp[i][j] = Math.max(LPS(s, i + 1, j), LPS(s, i, j - 1));         
      }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
            dp = new int[n][n];
            for (int[] row : dp) 
            {
                Arrays.fill(row, -1);
            }
             return LPS(s, 0, n - 1); 
        
    }
}

 ================================================================================================ 
//Approach-2 (Bottom Up)
//T.C : O(n*n)
//S.C : O(n*n)
---------------------------------------------------------
  class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i<n;i++)
            dp[i][i] = 1;

        for (int L = 2; L <= n; L++) 
        {
             for (int i = 0; i < n - L + 1; i++)
             {
                  int j = i + L - 1;
                  if (s.charAt(i) == s.charAt(j) && L == 2)
                      dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
             }
        }
        return dp[0][n-1];   
    }
}
