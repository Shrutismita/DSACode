Q:- https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
*********************************************************************************************************
  class Solution {
    public int numWays(int steps, int arrLen) {
         int mod = 1000000007;
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= steps; j++)
        {
            for (int idx = arrLen - 1; idx >= 0; idx--)
            {
                  int ans = dp[idx][j - 1];
                if (idx > 0) 
                     ans = (ans + dp[idx - 1][j - 1]) % mod;
                if (idx < arrLen - 1) 
                    ans = (ans + dp[idx + 1][j - 1]) % mod;

                dp[idx][j] = ans;
            }
        }
        return dp[0][steps];
    }
}
