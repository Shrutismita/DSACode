Q:- https://leetcode.com/problems/unique-paths-ii/
***************************************************************
//Using Recursion with memoization  
//Time complexity: O(m*n)
//Space complexity: O(m*n)
----------------------------------------------------------
  class Solution {
    int[][] ans;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        ans = new int[m][n];
        for(int[] a:ans)
        Arrays.fill(a,-1);
        this.dp=obstacleGrid;
        
        return solve(m-1,n-1);
    }
    int solve(int i, int j)
    {
        
        if(i<0 || j<0 || dp[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(ans[i][j]!=-1) return ans[i][j];
        else
        {
            int up= solve(i,j-1);
            int left = solve(i-1,j);
            ans[i][j]= up+left;
            return ans[i][j];
        }
    }
}
==================================================================================
//Using Top Down appraoch  
//Time complexity: O(m*n)
//Space complexity: O(m*n)
------------------------------------------------------
  class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];
        ans[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j>0 && ans[i][j-1]!=-1 ) ans[i][j]=ans[i][j-1];
                if(i>0 && ans[i-1][j]!=-1) ans[i][j]+=ans[i-1][j];
                if(obstacleGrid[i][j]==1) ans[i][j]=0;
            }
        }
        return ans[m-1][n-1];
    }
 }
