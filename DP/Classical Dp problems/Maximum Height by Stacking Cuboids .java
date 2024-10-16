Q:- https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
*********************************************************************************
  class Solution {
      public int solveMem(int[][]cuboids,int cur,int prev,int dp[][]){
        if(cur>=cuboids.length){
            return 0;
        }
        if(dp[cur][prev+1]!=-1){
            return dp[cur][prev+1];
        }
        int include=0,exclude=0;
        if(prev==-1|| (cuboids[cur][0]>=cuboids[prev][0] &&cuboids[cur][2]>=cuboids[prev][2] &&cuboids[cur][1]>=cuboids[prev][1] )){
            include=cuboids[cur][2]+solveMem(cuboids,cur+1,cur,dp);
        }
        exclude=solveMem(cuboids,cur+1,prev,dp);
        return dp[cur][prev+1]=Math.max(include,exclude);
    }
    public int maxHeight(int[][] cuboids) {
     //step1: sort dimensions of each cubpid
        for(int d[]: cuboids){
            Arrays.sort(d);
        }
        // sort cuboids on basis of width that is 1st element 
        Arrays.sort(cuboids,new Comparator<int[]>(){
            public int compare(int []a,int b[]){
                if(a[0]!=b[0]){
                     return Integer.compare(a[0],b[0]);
                }
                else if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[2], b[2]);
                }
            }
        });
        int dp[][]=new int[cuboids.length][cuboids.length+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solveMem(cuboids,0,-1,dp);
    }
}
