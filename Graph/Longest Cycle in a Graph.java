Q:- https://leetcode.com/problems/longest-cycle-in-a-graph/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  Approach - 1 (Using DFS)
  ---------------------------
  class Solution {
    int result = -1;
     void dfs(int[] edges, int u,boolean[] visited, int[] dist, boolean[] inRecursion)
     {
         if(u != -1) 
         {
                visited[u] = true;
                inRecursion[u] = true;

                int v = edges[u];
                if(v != -1 && !visited[v])
                {
                    dist[v] = dist[u] + 1;
                    dfs(edges, v,visited, dist, inRecursion);
                }
               else if(v != -1 && inRecursion[v] == true) 
               { //cycle
                
                result = Math.max(result, dist[u] - dist[v] +1);
                
              }
                inRecursion[u] = false;
         }
           

     }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist,1);

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
            {
                dfs(edges, i,visited, dist, inRecursion);
            }
        }
        return result;
    }
}
