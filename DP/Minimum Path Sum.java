Q:- https://leetcode.com/problems/minimum-path-sum/
****************************************************************************************
//Approach-1 (Recur + Memoization)
//Time complexity: O(n*m)
//Space complexity:  O(n*m)
--------------------------------------------------
 class Solution {
    int n;
    int m;
    int[][] dp;
    int solve(int[][] grid,int i, int j)
    {
         if(i == m-1 && j == n-1)
            return dp[i][j] = grid[i][j];
          if(dp[i][j] != -1) return dp[i][j];
        if(i == m-1) { //we can only go right
            return dp[i][j] = grid[i][j] + solve(grid, i, j+1);
        } else if(j == n-1) { //we can go only down
            return dp[i][j] = grid[i][j] + solve(grid, i+1, j);
        } else {
            return dp[i][j] = grid[i][j] + Math.min(solve(grid, i+1, j), solve(grid, i, j+1));
        }
    }
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d,-1);

        return solve(grid,0,0);
    }
}
==============================================================================================
//Approach-2 (Bottom Up DP)
//Time complexity: O(n*m)
//Space complexity:  O(n*m)
--------------------------------------------------
  class Solution {
   
    int solve(int[][] grid,int m, int n)
    {
        int[][] dp = new int[m][n];
          dp[0][0] = grid[0][0];
        
        for(int i = 1; i<m; i++)
            dp[i][0] = dp[i-1][0]+grid[i][0];
        
        for(int j = 1; j<n; j++)
            dp[0][j] = dp[0][j-1]+grid[0][j];

        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       
        return solve(grid,m,n);
    }
}
