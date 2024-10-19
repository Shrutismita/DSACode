Q:- https://leetcode.com/problems/domino-and-tromino-tiling/
************************************************************************
//Approach-1 (Bottom Up)
//T.C: O(n)
-----------------------------------
  class Solution {
     int M = 1000000007;
    public int numTilings(int n) {
         if(n == 1 || n == 2)
            return n;

         int[] dp = new int[n+1];
          
           dp[1] = 1;
           dp[2] = 2;
           dp[3] = 5;
           for(int i = 4; i<=n; i++)
            {
               dp[i] = (2*dp[i-1]%M + dp[i-3]%M) % M;
            }
        
        return dp[n];
         
    }
}
=================================================================================
//Approach-2 (Recur + Memo) 
//T.C: O(n)
--------------------------------------------
  class Solution {
     int mod = 1000000007;    
      public int numTilings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private int solve(int n,int[] dp){
        if(n==1 || n == 2) return n;
       
        if(n==3) return 5;
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = (2*solve(n-1,dp)%mod + solve(n-3,dp)%mod)%mod;
    }
}
