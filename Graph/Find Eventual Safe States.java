Q:- https://leetcode.com/problems/find-eventual-safe-states/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
//Approach-1 (Using Same code of DFS Cycle Check in directed Graph)
  ------------------------------------------------------------------
  class Solution {
    boolean isCycleDFS(int[][] adj, int u,boolean[] visited, boolean[] inRecursion)
    {
        visited[u] = true;
        inRecursion[u] = true;
        for(int v : adj[u])
        {
            //if not visited, then we check for cycle in DFS
            if(visited[v] == false && isCycleDFS(adj, v, visited, inRecursion))
                return true;
            else if(inRecursion[v] == true)
                return true;
        }
        
        inRecursion[u] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                 isCycleDFS(graph, i, visited, inRecursion);
            }
        }
         List<Integer> safeNodes = new ArrayList<>(V);
        for(int i = 0; i<V; i++) {
            if(!inRecursion[i])
                safeNodes.add(i);
        }
        
        return safeNodes;
    }
}
===================================================================
  //Approach-2 (Using BFS) (Toplogical Sort)
  ----------------------------------------------
  class Solution {
    boolean isCycleDFS(int[][] adj, int u,boolean[] visited, boolean[] inRecursion)
    {
        visited[u] = true;
        inRecursion[u] = true;
        for(int v : adj[u])
        {
            //if not visited, then we check for cycle in DFS
            if(visited[v] == false && isCycleDFS(adj, v, visited, inRecursion))
                return true;
            else if(inRecursion[v] == true)
                return true;
        }
        
        inRecursion[u] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
         List<List<Integer>> adj = new ArrayList<>();
         for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
       
         int[] inDegree = new int[V];

        //1 Reverse the directed edges of the graph
        // Because we want here the outdegree int this question
        for(int i=0; i<V; i++)
        {
            for(int v : graph[i])
            {
                adj.get(v).add(i);
                inDegree[i]++;
            }
        }
       Queue<Integer> que = new LinkedList<>();
        //2. Fill que, indegree with 0
        for(int i = 0; i < V; i++)
        {
         if(inDegree[i] == 0)
         {
            que.add(i);
         }
        }
            List<Integer> res = new ArrayList<>();
            while(!que.isEmpty())
            {
                int node = que.poll();
                res.add(node);
                for(Integer adjacent: adj.get(node))
                {
                    inDegree[adjacent]--;
                     if(inDegree[adjacent]==0)
                     {
                        que.offer(adjacent);
                     }
                }
            }
        
           Collections.sort(res);
           return res;
    }
}
