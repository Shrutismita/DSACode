Q:- https://leetcode.com/problems/2-keys-keyboard/
***************************************************************
  class Solution {
    public int minSteps(int n) {
        if(n==1)
          return 0;

        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++)
        {
            dp[i]=i;
            for(int j=2;j<=Math.sqrt(i);j++)
            {
                if(i%j == 0)
                {
                   int factor1 = j;
                    int factor2 = i / j;

                    // Update dp[i] considering the minimum operations needed
                    dp[i] = Math.min(dp[i], dp[factor1] + (i / factor1));
                    dp[i] = Math.min(dp[i], dp[factor2] + (i / factor2));
                }
            }
        }
        return dp[n];
    }
}
