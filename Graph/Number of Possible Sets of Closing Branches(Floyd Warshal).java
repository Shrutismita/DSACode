Q:- https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/
***************************************************************************************
  //Approach (Using Floyd Warshal) - Because of following reasons
//It asks for shortest distance between every pair of vertices
//Since the number of vertices is very less 1 <= n <= 10 , we can apply Floyd Warshal - T.C :  O(n^3) of Floyd Warshal
//T.C : O((2^n) * (n^3))
//S.C : O(n^2)

  ----------------------------------------------------------------
  class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
          int ans = 0;

        // Total number of possible subsets with n nodes = 2^n = (1 << n) = Math.pow(2, n)
        for (int set = 0; set < (1 << n); set++) {
            // Create an adjacency matrix to represent the graph
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = 1_000_000_000; // Initialize with a large value
                }
            }

            // Update the graph based on the selected nodes in the subset
            for (int[] it : roads) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if ((set >> u & 1) == 1 && (set >> v & 1) == 1) {
                    grid[u][v] = Math.min(grid[u][v], wt);
                    grid[v][u] = Math.min(grid[v][u], wt);
                }
            }

            // Set diagonal elements to 0
            for (int j = 0; j < n; j++) {
                grid[j][j] = 0;
            }

            // Floyd-Warshall algorithm for finding the shortest paths
            for (int via = 0; via < n; via++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        grid[x][y] = Math.min(grid[x][y], grid[x][via] + grid[via][y]);
                    }
                }
            }

            // Check if the current subset forms a valid set
            boolean isFeasible = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;

                    if ((set >> j & 1) == 1 && (set >> k & 1) == 1) {
                        if (grid[j][k] > maxDistance) {
                            isFeasible = false;
                            break;
                        }
                    }
                }
            }

            // Increment the answer if the subset was valid
            ans += isFeasible ? 1 : 0;
        }
        return ans;
    }
}
