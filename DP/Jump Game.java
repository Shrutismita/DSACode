Q:- https://leetcode.com/problems/jump-game/
**************************************************************
  //Recursion+Memoization
  -------------------------------------
  class Solution {
      Boolean[] dp;
     boolean solve(int[] nums, int n, int idx) {
        if(idx == n-1)
            return true;
        
        if(dp[idx] != null)
            return dp[idx];
        
        for(int i = 1; i <= nums[idx]; i++) {
            if(solve(nums, n, idx+i))
                return dp[idx] = true;
        }
    
        return dp[idx] = false;
    }
    public boolean canJump(int[] nums) {
         int n = nums.length;
        dp = new  Boolean[n+1];
        return solve(nums, n, 0);
    }
}
====================================================================
//Approach-2 (Bottom Up)
//T.C : O(n^2)
------------------------------------------------
  class Solution {
      
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        
        dp[nums.length-1] = true;
        
        for(int i=nums.length-2; i>=0; i--){
            int start = i+1;
            int end = i+nums[i];
            for(int j=start; j<=end; j++){
                if(dp[j] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
}
