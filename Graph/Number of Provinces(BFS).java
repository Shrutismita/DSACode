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
            int curr = queue.poll();
           //Visit neighbours
            for(int v : adj.get(curr)) {
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
  //Approach-2 : [ Using BFS - Using given input graph]
class Solution {
     private void bfs(int adj[][],int u ,boolean [] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(u);
        visited[u]=true;
        
        while(!que.isEmpty()) {
            int curr = que.poll();
            //Visit neighbours
            for(int v = 0; v < adj.length; v++) {
                if(adj[curr][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    que.add(v);
                }
            } 
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited =new boolean[isConnected.length];
        int count=0;
        for (int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                bfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
        
    }
   
}
