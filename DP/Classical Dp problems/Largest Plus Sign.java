Q:- https://leetcode.com/problems/largest-plus-sign/
*****************************************************************************
//T.C : O(n*n)
//S.C : O(n*n)
------------------------------------------------------------------------------
  class Solution {
      // count of 1 from left in same row
      short[][] rowDp ;
        // count of 1 from up in same column
        short[][] colDp;
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // `mines` array contains unique points.
        // If its length equals n * n, it means all points are zero.
        if(mines.length == n*n) return 0;

        rowDp = new short[n][n];
        colDp = new short[n][n];

        for (int[] points : mines) {
            // For zero points, set their value to -1, such the next element will have dp count as 0
            rowDp[points[0]][points[1]] = -1;
            colDp[points[0]][points[1]] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                  if (rowDp[i][j] != -1) {
                    rowDp[i][j] = (short) (rowDp[i][j - 1] + 1);
                    colDp[i][j] = (short) (colDp[i - 1][j] + 1);
                }
            }
        }
        int arm = 0;
        int low = 1, high = (n - 1) / 2, middle;

           // Binary search
        while (low <= high) {
            middle = (low + high) / 2;
            if (search(middle, n)) {
                arm = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        // order is arm length + 1
        return arm + 1;
    }
    private boolean search(int arm, int n) {
        int bound = n - arm;

        for (int i = arm; i < bound; i++) {
            for (int j = arm; j < bound; j++) {
                if (rowDp[i][j] >= arm
                    && colDp[i][j] >= arm
                    && rowDp[i][j + arm] - rowDp[i][j] >= arm
                    && colDp[i + arm][j] - colDp[i][j] >= arm) {
                    return true;
                }
            }
        }

        return false;
    }
}
