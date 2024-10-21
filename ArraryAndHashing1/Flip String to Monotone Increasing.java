Q:- https://leetcode.com/problems/flip-string-to-monotone-increasing/
*************************************************************************************************
//Approach-1 (Using Recursion + Memoization)
// Time Complexity: O(n)
// Space Complexity: O(n)
-------------------------------------------------------------------------
  class Solution {
    int[][] dp;
    int n;
    int solve(String s,int curr_index, int prev)
    {
         if(curr_index >= s.length())
            return 0;

         if(dp[curr_index][prev] != -1)
               return dp[curr_index][prev];

           int flip = Integer.MAX_VALUE;
           int no_flip = Integer.MAX_VALUE;

           if(s.charAt(curr_index) == '0')
           {
               if(prev == 0)
               {
                   flip = 1 + solve(s,curr_index+1,1);
                   no_flip = solve(s,curr_index+1,0);
               }
               else
               {
                    flip =  1 + solve(s,curr_index+1,1);
               }
           }
           else if(s.charAt(curr_index) == '1') 
           {
                 if(prev == 1)
                 {
                    no_flip = solve(s,curr_index + 1, 1);
                 }
                 else
                 {
                    flip = 1 +  solve(s,curr_index + 1, 0);
                    no_flip = solve(s,curr_index + 1, 1);
                 }
           }  
           return dp[curr_index][prev] = Math.min(flip,no_flip);
    }
    public int minFlipsMonoIncr(String s) {
        n = s.length();
        dp = new int[n+1][2];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(s,0,0);
    }
}
