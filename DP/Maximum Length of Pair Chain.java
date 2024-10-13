Q:- https://leetcode.com/problems/maximum-length-of-pair-chain/

  /*
  NOTE - Since this problem is a variant of LIS (only difference is that the Qn says that we can pick the element in any order)
  So we sort the input in ascending order to get the longest chain of pairs.
  Also, since it's variant of LIS, it can be solved using all those methods by which LIS could be solved.
*/

***********************************************************************************************************************
  //Approach-1 (Using Simple LIS recursion+memo: TopDown) - Since Qn asks to take pairs in any order, we sort it in the beginning
  //T.C: O(n*n)
  //S.C : O(n)
  ------------------------------------------------------------------------------------------------------

  class Solution {
    int[][] dp;
    int n;
    int lis(int[][] nums,int curr_idx,int prev_idx)
    {
        if(curr_idx == n) return 0;
        
        if(prev_idx != -1 && dp[curr_idx][prev_idx] != -1)
        {
            return dp[curr_idx][prev_idx];
        }
        int take = 0;
        if(prev_idx == -1 || nums[curr_idx][0] > nums[prev_idx][1])
        {
            take = 1 + lis(nums,curr_idx+1,curr_idx);
        }
       int not_take = lis(nums, curr_idx+1,prev_idx);

       if(prev_idx != -1)
            dp[curr_idx][prev_idx] =  Math.max(take, not_take);

        return Math.max(take, not_take);  
    }
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new int[n][n];
        for(int i = 0; i < n; i++)
              Arrays.fill(dp[i],-1);

        Arrays.sort(pairs,(a,b)->a[1]-b[1]);

        return lis(pairs,0,-1);      
    }
}
======================================================================================================================
  //Approach-2 (Using Simple LIS Bottom Up) - Since Qn asks to take pairs in any order, we sort it in the beginning
   //T.C: O(n*n)
  //S.C : O(n)
  ---------------------------------------------------------------
  class Solution {
  
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
         int[] dp = new int[n];
        for(int i = 0; i < n; i++)
              Arrays.fill(dp,1);

        Arrays.sort(pairs,(a,b)->a[1]-b[1]);

        int maxLIS = 1;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < i;j++)
            {
                 if(pairs[j][1] < pairs[i][0]) 
                 {
                     dp[i] = Math.max(dp[i], dp[j]+1);
                      maxLIS = Math.max(maxLIS, dp[i]);
                 }
            }
        }
        return maxLIS;   
    }
}
  
