Q: 980. https://leetcode.com/problems/unique-paths-iii/

T.C : O(3^m*n)
S.C : O(n)
===========================================================================
  class Solution {
    int m, n;
     int result;
     int nonObstacles;
     int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int uniquePathsIII(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
         result = 0;
         nonObstacles = 0;
         int start_i = 0, start_j = 0;
         for(int i = 0 ; i< m ; i++)
         {
            for(int j =0 ; j < n ; j++)
            {
                if(grid[i][j] == 0)
                nonObstacles++;
                if(grid[i][j] == 1){
                    start_i = i;
                    start_j = j;
                }
            }
         }
         nonObstacles += 1;
         int count = 0;
         backTrack(grid,count,start_i,start_j);
         return result;
    }
    void backTrack(int[][] grid, int count , int i,int j)
    {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1)
        return;
        if(grid[i][j] == 2)
        {
            if(count == nonObstacles)
            {
                result++;
            }
            return ;
        }
        grid[i][j] = -1;
        for(int[] dir : directions)
        {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            backTrack(grid,count + 1, new_i,new_j);
        }
        grid[i][j] = 0;

    }
}
