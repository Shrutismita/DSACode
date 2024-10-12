Q:- https://leetcode.com/problems/maximum-alternating-subsequence-sum/
********************************************************************************************
  //Approach-1 (Recursion + Memo) 
  //Time Complexity - O(n)
 //Space complexity: O(n)
  --------------------------------------------------------------------
  class Solution {
    int n;
    long[][] dp;
   long solve(int idx, int[] nums, boolean iseven)
   {
       if(idx >= n) return 0;
       if(dp[idx][iseven ? 1 : 0] != -1)
       {
        return dp[idx][iseven ? 1 : 0];
       }
        // Option to skip the current element
       long skip = solve(idx+1,nums,iseven);

       // Option to take the current element
       long val = nums[idx];
       if(iseven == false) 
       {
        val = -val;// Subtract the element if flag is false (odd index in subsequence)
       }
       long take = solve(idx+1,nums,!iseven) + val;

       return dp[idx][iseven ? 1: 0] = Math.max(skip,take);

   }
    public long maxAlternatingSum(int[] nums) {
         n = nums.length;
      
        dp = new long[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, nums, true);
    }
}
=============================================================================================
  //Approach-2 (Bottom Up) 
  //T.C : O(n)
  //space : O(n)
  -------------------------------------------------
  class Solution {
         
  
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
      
       long[][] dp = new long[n+1][2];
       
         dp[0][0] = Math.max(-nums[0], 0);
         dp[0][1] = Math.max(nums[0], 0);

          for(int i = 1; i < n; i++) 
          {
             dp[i][0] = Math.max(dp[i-1][1] - nums[i], dp[i-1][0]);
            
             dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
          }

           return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
