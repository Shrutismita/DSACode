Q:- https://leetcode.com/problems/min-cost-climbing-stairs/
**************************************************************************
//Time complexity: O(n)
//Space complexity: O(n) 
---------------------------------------------------------
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length; i++){
            int s = dp[i-1];
            int f = dp[i-2];
            dp[i] = Math.min(s,f) + cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
