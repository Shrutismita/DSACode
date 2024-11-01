Q:- https://leetcode.com/problems/regions-cut-by-slashes/
**************************************************************************************
//Approach-1 (DSU)
//Time Complexity: O((n+1)² * α((n+1)²)), where α is the inverse Ackermann function, which is nearly constant.
//We are performing union-find operations on an (n+1) x (n+1) grid.
//Space Complexity: O((n+1)²).  
----------------------------------------------------------------------------------------------
  class Solution {
    private int[] p;
    private int cnt;

    private void dsu(int n1, int n2) {
        int up1 = findUp(n1);
        int up2 = findUp(n2);
        if (up1 == up2) {
            cnt++;
            return;
        }
        p[up2] = up1;
    }

    private int findUp(int node) {
        if (node == p[node]) return node;
        return p[node] = findUp(p[node]);
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int nn = n + 1;

        p = new int[nn * nn];
        cnt = 0;
        for (int i = 0; i < nn * nn; i++) p[i] = i;

        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < nn; j++) {
                if (i == 0 || j == 0 || i == n || j == n) 
                    dsu(0, i * nn + j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    dsu((i + 1) * nn + j, i * nn + (j + 1));
                } else if (grid[i].charAt(j) != ' ') {
                    dsu(i * nn + j, (i + 1) * nn + (j + 1));
                }
            }
        }
        return cnt;
    }
}
======================================================================================================
//Approach-2 Using Dfs
//Time complexity:O(n∗m∗9∗(4∗alpha))
//Space complexity:O(n∗m∗9+K)  
---------------------------------------------------
  class Solution {
      private int DFS(int[][] dp, int i, int j) {
        // edge
        if (Math.min(i, j) < 0 || Math.max(i, j) >= dp.length || dp[i][j] != 0) {
            return 0;
        }

        dp[i][j] = 1;
        return (1 + DFS(dp, i, j + 1) + DFS(dp, i, j - 1)
                + DFS(dp, i + 1, j) + DFS(dp, i - 1, j));
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int[][] dp = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    dp[i * 3][j * 3 + 2] = dp[i * 3 + 1][j * 3 + 1] = dp[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    dp[i * 3][j * 3] = dp[i * 3 + 1][j * 3 + 1] = dp[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < 3 * n; j++) {
                res += DFS(dp, i, j) > 0 ? 1 : 0;
            }
        }
        return res;
    }
}
