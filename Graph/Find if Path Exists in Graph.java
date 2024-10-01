Q:- https://leetcode.com/problems/find-if-path-exists-in-graph/
T.C:- O(n)
S.C:- O(n + m)  
================================================================================================================================
  //Approach -1 Using DFS
  ------------------------------
  class Solution {
    boolean dfsCheck(List<List<Integer>> adj,int node,int destination,boolean[] visited)
    {
        if(node == destination)
               return true;

        if(visited[node] == true)
              return false;

        visited[node] = true;
        for(int curr : adj.get(node))
        {
            if(dfsCheck(adj,curr,destination,visited))
               return true;
        }             
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
               return true;

         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
         } 

         boolean[] visited = new boolean[n];

         return dfsCheck(adj,source,destination,visited); 
    }
}
================================================================================================================================
  //Approach -2 Using BFS
  ------------------------------
  class Solution {
   
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
               return true;

         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
         } 

         boolean[] visited = new boolean[n];
         Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            if(node == destination)
                 return true;
            for(int curr : adj.get(node))
            {
                if(visited[curr] == false)
                {
                    visited[curr] = true;
                    queue.add(curr);
                }
            }     
        }
        return false;
    }
}
