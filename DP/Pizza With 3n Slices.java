Q:- https://leetcode.com/problems/pizza-with-3n-slices/
*******************************************************************************
//Approach-(TOP-DOWN/Recursion+MEMOIZATION  )
---------------------------------------------------------
  class Solution {
    int[][] dp;
     int solve(int start,int end,int[] slices,int n,int[][] dp)
    {
        if(n==0||start>end)
            return 0;
        if(dp[start][n]!=-1)
            return dp[start][n];
        
            int take = slices[start] + solve(start+2,end,slices,n-1,dp);
            int notTake =  0 + solve(start+1,end,slices,n,dp);
                
                dp[start][n]= Math.max(take,notTake);
        return dp[start][n];
    }
    public int maxSizeSlices(int[] slices) {
         int n=slices.length;
         dp = new int[n][n/3+1] ;
         for(int val[] : dp) Arrays.fill(val , -1);
          int case1 = solve(0,slices.length-2,slices,slices.length/3,dp);
         for(int val[] : dp) Arrays.fill(val , -1);
        int case2 = solve(1,slices.length-1,slices,slices.length/3,dp);
        return Math.max(case1,case2);
    }
}
