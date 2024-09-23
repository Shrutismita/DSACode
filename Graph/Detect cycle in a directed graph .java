Q:- https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
  Directed Graph Cycle
  Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
  ==============================================================================================
T.C:- O(V+E)
S.C:- O(V)
=======================================================--------Using DFS---------==========================================================
  Approach -1

  class Solution {
    boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj , int u , boolean[] visited, boolean[] inRecursion)
    {
        visited[u] = true;
        inRecursion[u] = true;
        
        for(Integer v : adj.get(u))
        {
            //If not visited, then we check for cycle in DFS
            if(visited[v] == false && isCycleDFS(adj,v,visited,inRecursion))
            {
                return true;
            }
            else if(inRecursion[v] == true)
            {
                return true;
            }
        }
         inRecursion[u] = false;
         return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for(int i = 0; i < V ; i++)
        {
            if(!visited[i] && isCycleDFS(adj,i,visited,inRecursion))
            {
                return true;
            }
        }
        return false;
    }
}
====================================================================================================================================
