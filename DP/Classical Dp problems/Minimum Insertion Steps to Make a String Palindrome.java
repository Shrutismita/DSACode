Q:- https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
********************************************************************************************
  Approach- Using Recursion + Memoization
  --------------------------------------------
  class Solution {
    public int minInsertions(String s) {
    int n = s.length();
        return helper(s.toCharArray(), 0, n-1, new Integer[n][n]);
    }
     public int helper(char[] arr, int i, int j, Integer[][] mem) {
        if(i>=j)
            return 0;
        if(mem[i][j] != null)
            return mem[i][j];
        if(arr[i] == arr[j])
            return mem[i][j] = helper(arr, i+1, j-1, mem);
        return mem[i][j] = Math.min(1+helper(arr, i+1, j, mem), 1+helper(arr, i, j-1, mem));
    }
}
