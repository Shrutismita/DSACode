Q:- https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
*********************************************************************************
  //Approach-1 (Recursion + Memoization)
//T.C : O(n^2*d)
//S.C : O(301*11) ~= O(1)
---------------------------------------------------------
  class Solution {
    int[][] dp;
    int solve(int[] jobDifficulty, int n, int idx, int d) 
    {
         // If you have only 1 day, then you will do all the remaining jobs
        // and select the max difficulty as the answer
        if (d == 1) {
            int maxD = jobDifficulty[idx];
            for(int i = idx; i < n; i++)
            {
                maxD = Math.max(maxD,jobDifficulty[i]);
            }
            return maxD;
        }
         if (dp[idx][d] != -1)
            return dp[idx][d];

        int maxDifficulty = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        // Try one by one with all possibilities
        /*
         * Take 1 job in one day Take 2 jobs in one day Take 3 jobs in one day and so
         * on Then find the optimal one among all the results
         */
        for (int i = idx; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            result = Math.min(result, maxDifficulty + solve(jobDifficulty, n, i + 1, d - 1));
        }

        return dp[idx][d] = result;
    
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

          dp = new int[n][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(jobDifficulty, n, 0, d);
    }   
    
}
