Q:- https://leetcode.com/problems/house-robber-ii/
*********************************************************************************
  //Approach-1 (Recursion + Memorization/Top Down)
  ----------------------------------------------------
  class Solution {
    int[] dp;
     int solve(int[] nums, int i, int n) 
     {
        if(i > n) return 0;

        if(dp[i] != -1)
           return dp[i];

        int take = nums[i] + solve(nums, i+2, n); //steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i+1, n); //skips this house, now we can move to adjacent next house
        
        return dp[i] = Math.max(take, skip);   
     }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[101];
        
        if(n == 1) 
            return nums[0];

        if(n == 2)
            return Math.max(nums[0],nums[1]); 

         Arrays.fill(dp , -1);
        //case-1 - Take first house 0th index wala house        
        int take_0th_index_house = solve(nums,0,n-2);

         Arrays.fill(dp , -1);
        //case-2  - Take second house 1st index wala house
        int take_1st_index_house = solve(nums,1,n-1);

    return Math.max(take_0th_index_house, take_1st_index_house);
    }
}
============================================================================================
  //Approach-2 (Using Bottom Up similar to House Robber-1 and just taking two cases
/*
    Case-1 (Take from 1st House - Hence skip the last house)
    Case-2 (Take from 2nd House - Hence take the last house)
*/
  ------------------------------------------------------------------
  class Solution {
         
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
       
        if(n == 1) 
            return nums[0];

          Arrays.fill(dp,0);
        //dp[i] = Max money gained from i houses        
        int result1 = 0;
        int result2 = 0;
        //Case-1 (Take from 1st House - Hence skip the last house)
        dp[0] = 0;
          for(int i = 1; i<=n-1; i++) {
            dp[i] = Math.max(dp[i-1] , nums[i-1]+ ((i-2 >= 0) ? dp[i-2] : 0 ));
        }
        result1 = dp[n-1];
        
        dp = new int[n+1];
        Arrays.fill(dp,0);
        //Case-2 (Take from 2nd House - Hence take the last house)
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i<=n; i++) {
            dp[i] = Math.max(dp[i-1] , nums[i-1]+ ((i-2 >= 0) ? dp[i-2] : 0 ));
        }
        result2 = dp[n];
        
        return Math.max(result1, result2);

    }
}
  
