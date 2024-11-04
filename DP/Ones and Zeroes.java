Q:- https://leetcode.com/problems/ones-and-zeroes/
*************************************************************************
 //Time complexity: O(size * m * n), where 'size' is the number of binary strings, and 'm' and 'n' are the maximum allowed zeros and ones, respectively.

//Space complexity: O(size * m * n) because we are using a 3D DP array to store the results of subproblems.
--------------------------------------------------------------------------------------------------------------------
  class Pair{
    int zero;
    int ones;
    Pair(int zero,int ones){
        this.zero = zero;
        this.ones = ones;
    }
}
class Solution {
     public int solve(String[] strs,int ind,int zeroes,int ones,HashMap<String,Pair> map,int size,int[][][] dp){

        if(zeroes==0 && ones==0 || ind==size) return 0;

        if(dp[ind][zeroes][ones]!=-1) return dp[ind][zeroes][ones];

        int curr_zeroes = 0;
        int curr_ones = 0;

        int take = Integer.MIN_VALUE;
        String s = strs[ind];

        if(map.get(s).zero<=zeroes && map.get(s).ones<=ones){
            take = 1 + solve(strs,ind+1,zeroes-map.get(s).zero,ones-map.get(s).ones,map,size,dp);
        }

        int not_take = solve(strs,ind+1,zeroes,ones,map,size,dp);

        return dp[ind][zeroes][ones]= Math.max(take,not_take);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<String,Pair> map = new HashMap<>();
       for(String s:strs){
            int zero = 0;
            int one = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') zero++;
                else one++;
            }
            map.put(s,new Pair(zero,one));
        }
        int size = strs.length;
        int[][][] dp = new int[size][m+1][n+1];
        for(int[][] matrix:dp) for(int[] rows:matrix) Arrays.fill(rows,-1);
        return solve(strs,0,m,n,map,size,dp);        
    }
}
