Q:- https://leetcode.com/problems/palindromic-substrings/
*****************************************************************************************
//Approach - Using Recursion+Memo
//Time complexity: O(n^2), where n is the length of the input string s.
//Space complexity: O(n^2), as we use a 2D array dp of size n x n.
 --------------------------------------------------------------------------
  class Solution {
    public int countSubstrings(String s) {
    int n = s.length();
        int count = 0;
        
        // dp[i][j] will be 'true' if the string from index i to j is a palindrome
        boolean[][] dp = new boolean[n][n];
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        // Check substrings of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
} 

  
