Q:- https://leetcode.com/problems/knight-probability-in-chessboard/
***********************************************************************************
  class Solution {
     public double getProbability(int n, int moves, int ro, int co,double dp[][][]){
        if(moves<0) return 1;
        if(ro>=n || co>=n || ro<0 || co<0) return 0;
        if(dp[ro][co][moves]!=-1.0) return dp[ro][co][moves];
        double a = getProbability(n,moves-1,ro+2,co+1,dp);
        double b = getProbability(n,moves-1,ro+2,co-1,dp);
        double c = getProbability(n,moves-1,ro+1,co+2,dp);
        double d = getProbability(n,moves-1,ro-1,co+2,dp);
        double e = getProbability(n,moves-1,ro-2,co+1,dp);
        double f = getProbability(n,moves-1,ro-2,co-1,dp);
        double g = getProbability(n,moves-1,ro+1,co-2,dp);
        double h = getProbability(n,moves-1,ro-1,co-2,dp);
        return dp[ro][co][moves] = (a+b+c+d+e+f+g+h)/8;

    }
    public double knightProbability(int n, int k, int row, int column) {
         double dp[][][] = new double[n][n][k+1];
        for(double[][] i:dp)
         for(double j[]:i) 
         Arrays.fill(j,-1);
        return getProbability(n,k,row,column,dp);
    }
}
