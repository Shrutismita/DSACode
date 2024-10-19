Q:- https://leetcode.com/problems/minimum-falling-path-sum/
**************************************************************************************
//Approach-1 (Recur + Memoization) 
//T.C : O(m*n)
//S.C : O(m*n)
-------------------------------------------------
  class Solution {
     public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int mini=Integer.MAX_VALUE;
        int dp[][]=new int[m+1][n+1];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,solve(matrix,0,i,dp));
        }
        
        return mini;
    }
    int solve(int[][] matrix,int row,int col,int[][] dp)
    {
        //base case
        if(col<0 || col>=matrix[0].length)
        {
            return (int)1e8;
        }
        if(row==matrix.length-1)
        {
            return matrix[row][col];
        }
        
        
        if(dp[row][col]!=Integer.MAX_VALUE)
            return dp[row][col];
        
        
        //row+1,col-1
        int sum1=matrix[row][col]+solve(matrix,row+1,col-1,dp);
        
        //row+1,col
        int sum2=matrix[row][col]+solve(matrix,row+1,col,dp);
        
        //row+1,col+1
        int sum3=matrix[row][col]+solve(matrix,row+1,col+1,dp);
        
        
        return dp[row][col]=Math.min(sum1,Math.min(sum2,sum3));
        
    }
}
==========================================================================================
//Approach-2 (Bottom UP DP) : O(m*n)
//T.C : O(m*n)
//S.C :  O(m*n)
-----------------------------------------------------------------
  class Solution {
     public int minFallingPathSum(int[][] matrix) {
          int m = matrix.length;
        int[][] t = new int[m][m];

        // initialization
        for (int col = 0; col < m; col++) {
            t[0][col] = matrix[0][col];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < m; col++) {
                t[row][col] = matrix[row][col] + Math.min(
                        t[row - 1][col],
                        Math.min(t[row - 1][Math.max(0, col - 1)], t[row - 1][Math.min(m - 1, col + 1)])
                );
            }
        }

        return Arrays.stream(t[m - 1]).min().orElse(0);
    }
}
