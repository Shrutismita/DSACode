Q:- https://leetcode.com/problems/reducing-dishes/
****************************************************************
//Approach-1 -> Recursion + Memo : Knapsack
//Time complexity: O(n^2)
//Space complexity: O(n^2)
--------------------------------------------------------
  class Solution {
    int n ;
    int[][] dp;
    int solve(int[] satisfaction, int i, int time)
    {
        if(i == n) return 0;

        if(dp[i][time] != -1)
                return dp[i][time];

        int include =  satisfaction[i]*time + solve(satisfaction,i+1,time+1);
        int exclude = solve(satisfaction,i+1,time);

        return dp[i][time] = Math.max(include,exclude);  
    }
    public int maxSatisfaction(int[] satisfaction) {
         n = satisfaction.length;
         dp = new int[n+1][n+1];
         for(int[] row : dp)
             Arrays.fill(row, -1);
           Arrays.sort(satisfaction);
         return solve(satisfaction,0,1);    

    }
}
===================================================================================================
//Approach-2 -> Bottom Up
//Time complexity: O(n^2)
//Space complexity: O(n^2)
 -------------------------------------------------------------------
  class Solution {
  
    public int maxSatisfaction(int[] satisfaction) {
          Arrays.sort(satisfaction);
         int n = satisfaction.length;
         int [][] dp = new int[n + 1][n + 1];
           int index = 0;
           int time = 0;
         for(index = satisfaction.length; index >= 0; index--){
             for(time = index; time >=0; time--){
                 if(index == satisfaction.length)
                     continue;
            
                 int includeDish = (satisfaction[index] * (time + 1)) + dp[index + 1][time + 1];
                 int excludeDish = dp[index + 1][time];

                 dp[index][time] = Math.max(includeDish, excludeDish);
             }
         }
        
         return dp[0][0];
    }
}
