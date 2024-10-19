Q:- https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
****************************************************************************************
//SC :- O(m∗n)
//TC :- O(m∗n) 
----------------------------------------------------
  class Solution {
     Integer memo[][],m,n;
    int ss1[], ss2[]; 
    public int minimumDeleteSum(String s1, String s2) {
        memo=new Integer[1+(m=s1.length())][1+(n=s2.length())];
        ss1=new int[m+1]; ss2=new int[n+1];
      //Preprocessing the cummulative sum of ascii values.
        for(int i=m-1;i>=0;--i) ss1[i]+=s1.charAt(i)+ss1[i+1];
        for(int i=n-1;i>=0;--i) ss2[i]+=s2.charAt(i)+ss2[i+1];
        return solve(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }
    private int solve(char[] s1, char[] s2, int i, int j){
          //If there is no string left to calculate in one of the strings,
          //we must add all the character asciis in the other strings which
          //are left.
        if(i>=m) return ss2[j];
        if(j>=n) return ss1[i];
        if(memo[i][j]!=null) return memo[i][j];
        //If they ith and jth characters are same, no need to add the ascii
        if(s1[i]==s2[j]) return memo[i][j]=solve(s1,s2,i+1,j+1);
       //Finding the minimum result after deleting any one of the characters
        return memo[i][j]=Math.min(s1[i]+solve(s1,s2,i+1,j), s2[j]+solve(s1,s2,i,j+1));
    }
}
