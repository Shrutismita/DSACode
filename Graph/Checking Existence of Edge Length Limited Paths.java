Q:- https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  //Using DSU
  -----------------
  class Solution {
    int[] parent;
    int[] rank;
    int find(int x)
    {
        if(x == parent[x])
             return x;

         return parent[x] = find(parent[x]);    
    }
    void Union (int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) 
            return;
  
        if(rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if(rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
         rank = new int[n];
        parent = new int [n];
        for(int i = 0; i<n; i++)
            parent[i] = i;
          int m = queries.length;
            // storing {u, v, weight, original idx} by increasing weight
           int[][] sortedQueries = new int[m][4];
        for(int i = 0; i<queries.length; i++) 
        {
           sortedQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
          Arrays.sort(sortedQueries, (a,b) -> a[2] - b[2]);
        
        
        // sort edgeList by increasing weight 
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);
         int idx = 0;
        
        boolean[] res = new boolean[m];
        
        for (int i = 0; i < m; i++) {
            int[] q = sortedQueries[i];
            int w = q[2];
            
            // union all edges with weight less than current query
            while (idx < edgeList.length && edgeList[idx][2] < w) {
                int[] e = edgeList[idx++];
                int u = e[0], v = e[1];
                Union(u, v);
            }
            
            int uQuery = q[0], vQuery = q[1], id = q[3];
            res[id] = (find(uQuery) == find(vQuery));
        }
        
        return res;
    }
    
}
