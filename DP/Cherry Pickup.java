Q:- https://leetcode.com/problems/cherry-pickup/
*********************************************************
  class Solution {
     Integer[][][] memo;
   
      public int cherryPickup(int[][] grid,int r1,int c1,int r2) {
        int c2=r1+c1-r2;
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==grid.length-1 && c1==grid[0].length-1){
             return grid[r1][c1];
        }
        if(memo[r1][c1][r2]!=null){
            return memo[r1][c1][r2];
        }
        int cherry=0;
        if(r1==r2 && c1==c2){
            cherry+=grid[r1][c1];
        }else{
            cherry+=grid[r1][c1]+grid[r2][c2];
        }
        int dir1=cherryPickup(grid,r1+1,c1,r2+1);
        int dir2=cherryPickup(grid,r1,c1+1,r2);
        int dir3=cherryPickup(grid,r1+1,c1,r2);
        int dir4=cherryPickup(grid,r1,c1+1,r2+1);
        cherry+=Math.max(Math.max(dir1,dir2),Math.max(dir3,dir4));
        return memo[r1][c1][r2] = cherry;
    }    
    public int cherryPickup(int[][] grid) {
           int n=grid.length;
        memo=new Integer[n][n][n];
        int ans = cherryPickup(grid,0,0,0);
        return Math.max(0,ans);
    }
}
