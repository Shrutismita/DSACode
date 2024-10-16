Q:- https://leetcode.com/problems/range-sum-query-2d-immutable/
*********************************************************************************
  class NumMatrix {
             long[][] dp;
    public NumMatrix(int[][] matrix) {
        int ylen = matrix.length + 1, xlen = matrix[0].length + 1;
        dp = new long[ylen][xlen];
        for (int i = 1; i < ylen; i++)
            for (int j = 1; j < xlen; j++)
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int)(dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1]);
    }
}
