Q:- https://leetcode.com/problems/longest-increasing-subsequence/
*********************************************************************************************
  //Approach-1 (TopDown: Recur+Memo) 
//T.C : O(n*n)
--------------------------------------------------------
class Solution {
     public int getLIS(int[]nums, int prev, int[][]dp, int i){
        if(i == nums.length) return 0;
        if(prev != -1 && dp[prev][i] != -1) 
                return dp[prev][i];
        
        int max = Integer.MIN_VALUE, take = Integer.MIN_VALUE;
        
        if(prev == -1 || nums[i] > nums[prev]) 
                 take = 1 + getLIS(nums, i, dp, i+1);

        int skip = getLIS(nums, prev, dp, i+1);
        
        if(prev != -1) 
             return dp[prev][i] = Math.max(take, skip);

        return Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getLIS(nums, -1, dp, 0);
    }
   
}
==================================================================================
  //Approach-2 (Bottom Up DP) 
  //T.C : O(n*n)
  -------------------------------------------
  class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[nums.length];
          Arrays.fill(dp, 1);
          
        int maxLIS = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxLIS = Math.max(maxLIS,dp[i]);
                }
            }
            
        }  
        return maxLIS;
    }
   
}
  
