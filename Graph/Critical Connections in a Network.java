Q:- https://leetcode.com/problems/critical-connections-in-a-network/
    Company Tags  : Amazon
 ************************************************************************************************
//Using Tarjan's Algorithm with DFS 
//Time complexity: O(V+E) The DFS traversal visits each node once and processes each edge once, contributing to the complexity.
//Space complexity: O(V+E)
 --------------------------------------------
  class Solution {
    int time = 0;
    void dfs(List<List<Integer>> adj, List<List<Integer>> criticals, int[] disc, int[] low, int[] parent, int u) 
    {
        disc[u] = time;
        low[u] = time;
        time++;
        
        for(int v: adj.get(u)){
            if(disc[v] == -1) {
                parent[v] = u;
                dfs(adj,criticals, disc,low,parent,v);

                low[u] = Math.min(low[u], low[v]);
                //low[u] = earliest visited vertex time (minimum disc time) that can be reached from v
                //So, if low[v] > disc[u], it means that v cannot reach u
                if(low[v] > disc[u]){//Then u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    criticals.add(Arrays.asList(u,v));
                }
            } else if(parent[u] != v) {  // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
            parent[i] = -1;
            disc[i] = -1;
            low[i] = -1;
        }

        for(List<Integer> edge : connections)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
         List<List<Integer>> criticals = new ArrayList<>();
        dfs(adj, criticals, disc, low, parent, 0);
        
        return criticals;
    }
}
