Q:- https://leetcode.com/problems/palindrome-partitioning-ii/
**************************************************************************
//TimeComplexcity:- O(n^2)
//SpaceComplexcity :- 
---------------------------  
 Approach - 1 Using Rcursion+Memoized Solution (Bottom Up DP)
  ----------------------------------------------------------------------
  class Solution {
      int dp[];
    private boolean isPalindrome(String s, int low, int high)
    {
        while(low < high)
        {
            if(s.charAt(low) != s.charAt(high))
            {
               return false;
            }
             low++;
             high--; 
                       
        }
        return true;
    }
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0) - 1;
    }
     public int solve(String s, int i){
        if(i == s.length())
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                int cost = 1 + solve(s, j+1);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }
}
============================================================================
  Approach - 2 (Tabulation)
 ---------------------------
  class Solution {
     
    private boolean isPalindrome(String s, int low, int high)
    {
        while(low < high)
        {
            if(s.charAt(low) != s.charAt(high))
            {
               return false;
            }
             low++;
             high--; 
                       
        }
        return true;
    }
    public int minCut(String s) {
       	int n = s.length();
		int[] dp = new int[n+1];
		Arrays.fill(dp, 0);
		for(int i = n-1; i>= 0; i--)
        {
			int minCost = Integer.MAX_VALUE;
			for(int j = i; j < n; j++){
				if(isPalindrome(s,i,j)){
					int cost = 1 + dp[j+1];
					minCost = Math.min(minCost, cost);
				}
			}
			dp[i] = minCost;
		}
		return dp[0] - 1;
    }
}              
