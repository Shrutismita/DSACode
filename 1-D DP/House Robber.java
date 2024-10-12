Q:- https://leetcode.com/problems/house-robber/
*********************************************************************************************
//Approach-1 (Using Recursion + Memoization / Top Down)
//T.C - O(2^n)
//S.C- O(n)
--------------------------------------------------
  class Solution {
    int[] dp;
    int solve(int[] nums, int i , int n)
    {
        if(i >= n) return 0;
        if(dp[i] != -1)
             return dp[i];
        int steal = nums[i] + solve(nums,i+2,n);
        int skip = solve(nums, i+1,n);
        return dp[i] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[101];
        Arrays.fill(dp, -1);
        return solve(nums, 0,n);
    }
}
========================================================================================
//Approach-2 (Bottom up)
//T.C - O(n)
//S.C- O(n)
--------------------------------------------------
  class Solution {   
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n == 1)
            return nums[0];
        dp[0] = 0;// no house : i = 0 
        dp[1] = nums[0];// 1 house : i = 1 
        for(int i =2; i <= n; i++)
        {
            int steal = dp[i-1];
            int skip = nums[i-1]+dp[i-2];
             /*
                SKIP  : If we skip this house,  then we have money till previous house  =  t[i-1]
                STEAL : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
            */
            dp[i] = Math.max(steal,skip);
        }
        return dp[n];
    }
}
