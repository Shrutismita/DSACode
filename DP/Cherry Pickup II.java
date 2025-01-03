Q:- https://leetcode.com/problems/cherry-pickup-ii/
*****************************************************************************
  class Solution {
    public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

        //dp[k][h][l] means that:
        //when bot1 at (k, h) and bot2 at(k, l), the max cherries we can have
        //when dp = -1, which means we cannot have bot at that position
        int[][][] dp = new int[n][m][m];

        //base case
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[0][i][j] = -1;
            }
        } 

        dp[0][0][m-1] = grid[0][0] + grid[0][m-1];

        int result = 0;

        for (int k = 1; k < n; k++) {
            for (int h = 0; h < m; h++) {
                for (int l = 0; l < m; l++) {
                    dp[k][h][l] = -1;     //don't forget this!

                    int leftMost1 = Math.max(0, h - 1);
                    int rightMost1 = Math.min(m - 1, h + 1);

                    int leftMost2 = Math.max(0, l - 1);
                    int rightMost2 = Math.min(m - 1, l + 1);

                    for (int i = leftMost1; i <= rightMost1; i++) {
                        for (int j = leftMost2; j <= rightMost2; j++) {
                            dp[k][h][l] = Math.max(dp[k][h][l], dp[k-1][i][j]);
                        }
                    }

                    if (dp[k][h][l] > -1) {
                        dp[k][h][l] += h == l ? grid[k][h] : grid[k][h] + grid[k][l];
                    }

                    if (k == n - 1) {
                        result = Math.max(result, dp[k][h][l]);
                    }
                }
            } 
        }

        return result;
    }
}
