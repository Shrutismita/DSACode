Q:-https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

*************************************************************************************
//Approach-1 (Using DFS)
//T.C : O(n^2)
//S.C : O(n)
------------------------------------------  
  class Solution {
    int n;
    void dfs(int[][] stones,int index, boolean[] visited)
    {
        visited[index] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i, visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
         n = stones.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            if(visited[i] == true) continue;
            dfs(stones,i,visited);
            count++;
        }
        return n - count;
    }
}
====================================================================================================
//Approach-2(Using DSU)
//T.C : O(n^2 * α(n))
//S.C : O(n) 
------------------------------------------------------------------------------
  class Solution {
     private int[] parent;
    private int[] rank;
    private int n;

    // Find function with path compression
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    // Union function with union by rank
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        if (rootI != rootJ) {
            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        n = stones.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize parent and rank arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Union stones that are in the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        // Count the number of disjoint sets (connected components)
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                groups++;
            }
        }

        // The number of stones that can be removed is total stones - number of groups
        return n - groups;
    }
}
  
