Q:- https://leetcode.com/problems/longest-common-subsequence/
**********************************************************************************
  class Solution {
     Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
         dp=new Integer[text1.length()+1][text2.length()+1];
        int ans=solve(text1,text2,text1.length()-1,text2.length()-1);
        return ans;
    }
    int solve(String text1,String text2,int l1,int l2)
    {
        //base case
        if(l1<0 || l2<0)
            return 0;
        
        //if value is present in dp array
        if(dp[l1][l2]!=null)
        {
            return dp[l1][l2];
        }
        
        //if character of both the string matches
        if(text1.charAt(l1)==text2.charAt(l2))
        {
            return dp[l1][l2]=1+solve(text1,text2,l1-1,l2-1);
        }
        //if character of both the string does not matches
        else
        {
            return dp[l1][l2]=Math.max(solve(text1,text2,l1,l2-1),solve(text1,text2,l1-1,l2));
        }
    }
}
