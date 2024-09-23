Q:- https://leetcode.com/problems/number-of-provinces/
T.C:- O(V+E)
S.C:- O(V)
=============================================================================================
  //Approach-1 : [ Using DFS - Creating our own Map as graph ]

  class Solution {
     
    void dfs(Map<Integer, List<Integer>> adj , int u ,boolean[] visited )
    {
        visited[u] = true;
        //Visit neighbours       
        for(int v : adj.get(u)) {
           if(!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
      
        Map<Integer, List<Integer>> adj = new HashMap<>();
      //1.create graph
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
      //2.
         boolean[] visited = new boolean[n];
         int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(visited[i]== false)
            {
                 dfs(adj,i,visited);
                 count++;
            }
        }
        return count;
    }
}
=================================================================================================================
  //Approach-2 : [ Using DFS - Using given input graph]

  class Solution {
     
    void dfs(Map<Integer, List<Integer>> adj , int u ,boolean[] visited )
    {
        visited[u] = true;
        //Visit neighbours
        //Find neighbours
        for(int v : adj.get(u)) {
           if(!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
       
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
         boolean[] visited = new boolean[n];
         int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(visited[i]== false)
            {
                 dfs(adj,i,visited);
                 count++;
            }
        }
        return count;
    }
}
  
