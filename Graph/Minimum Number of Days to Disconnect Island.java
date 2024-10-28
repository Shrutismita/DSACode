Q:- https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 Company Tags     : Amazon
 *******************************************************************************************
//Time complexity: O(N*M)
//Space complexity: O(N*M)
-------------------------------------
  class Solution {
   
    public int minDays(int[][] grid) {
           if(noOfIsland(grid)!=1)return 0;
       int n = grid.length;
       int m = grid[0].length;

       for(int i =0;i<n;i++){
           for(int j =0;j<m;j++){
               if(grid[i][j]==1){
                   grid[i][j] =0;
                   if(noOfIsland(grid)!=1)return 1;
                   grid[i][j] = 1;
               }
           }
       }
       return 2;
    }

    static int noOfIsland(int  grid[][]){
        int ans =0;
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

       for(int i =0;i<n;i++){
           for(int j =0;j<m;j++){
               if(!vis[i][j] && grid[i][j]==1){
                   ans++;
                   dfs(grid,i,j,n,m ,vis);
               }
           }
       }
       return ans; 
    }

    static void dfs(int grid[][] , int i , int j , int n , int m , boolean vis[][]){
        if(i<0 || j<0 || i==n || j==m || vis[i][j] || grid[i][j]==0)return ;

        vis[i][j] = true;
        dfs(grid,i+1,j,n,m,vis);
        dfs(grid,i-1,j,n,m,vis);
        dfs(grid,i,j+1,n,m,vis);
        dfs(grid,i,j-1,n,m,vis);
    }
}
