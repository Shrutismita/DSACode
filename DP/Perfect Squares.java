Q:- https://leetcode.com/problems/perfect-squares/
***************************************************************************************
//Approach-1 (Recursion with Memoizatin)
//T.C : O(n * sqrt(n))
//S.C : O(n)
--------------------------------------------------------
  class Solution {
    private int[] dp = new int[10001];
    private int minSquares(int n) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        // We can select only those perfect squares which can contribute to sum up to n
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minCount = Math.min(minCount, 1 + minSquares(n - i * i)); // 1 is for selecting one square number
        }

        return dp[n] = minCount;
    }

    public int numSquares(int n) {
        Arrays.fill(dp, -1);

        return minSquares(n);
    }
}
==========================================================================================
//Approach-2 (Bottom UP DP : O(n) space)
//T.C : O(n * sqrt(n))
//S.C : O(n)
---------------------------------------------------
  class Solution {
     public int numSquares(int n) {
        int[] t = new int[n + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        // t[i] = min number of perfect squares to get i
        t[0] = 0;

        for (int i = 1; i <= n; i++) {
            // For each i, it must be the sum of some number (i - j*j) and
            // a perfect square number (j*j).
            for (int j = 1; j * j <= i; j++) {
                int remain = i - j * j;
                t[i] = Math.min(t[i], 1 + t[remain]);
            }
        }

        return t[n];
    }
}
