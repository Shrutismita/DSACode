Q:- https://leetcode.com/problems/number-of-provinces/
T.C:- O(V+E)
S.C:- O(V)
==================================================================================
  //Approach-1 : [ Using BFS : Creating our own Map as graph ]
  class Solution {
     
    void bfs(Map<Integer, List<Integer>> adj , int u ,boolean[] visited )
    {
        Queue<Integer> queue = new LinkedList<>();
        visited[u] = true;
        queue.add(u);
        while(!queue.isEmpty()) {
            int u_1 = queue.poll();
           //Visit neighbours
            for(int v : adj.get(u_1)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
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
                 bfs(adj,i,visited);
                 count++;
            }
        }
        return count;
    }
}
====================================================================================================
