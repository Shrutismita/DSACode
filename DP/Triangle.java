Q:- https://leetcode.com/problems/triangle/
******************************************************************
  class Solution {
    int [][] dp;
      int solve(int i, int j,int n, List<List<Integer>> triangle)
      {

        if(i>=n||j>=n) return Integer.MIN_VALUE;

        if(i==n-1) return triangle.get(i).get(j);

        if(dp[i][j]!=-1) 
            return dp[i][j];

        int down = triangle.get(i).get(j)+ solve(i+1,j,n,triangle);
        int diagonal = triangle.get(i).get(j)+ solve(i+1,j+1,n,triangle);

        return dp[i][j] = Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
           dp =  new int [n][n];
            for(int [] i: dp) 
                  Arrays.fill(i,-1);
        return solve (0,0,n,triangle);
    }
}
