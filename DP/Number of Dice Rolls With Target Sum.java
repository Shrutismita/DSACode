Q:- https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
************************************************************************************
  class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
         Integer[][] dp = new Integer[n+1][target+1];
        return solve(0, n, k, target, dp);
    }
    public int solve(int idx, int n, int k, int target, Integer[][] dp){
        if(idx == n) return target == 0 ? 1 : 0;

        if(dp[idx][target] != null) return dp[idx][target];

        int count = 0;

        for(int i = 1; i <= k; i++){
            if(target < i) break;
             count+=(solve(idx+1, n, k, target - i, dp) % mod);
            count = count % mod;
        }

        return dp[idx][target] = count % mod;
    }
}
