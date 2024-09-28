Q:- https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

Distance from the Source (Bellman-Ford Algorithm)
  Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. 
  If a vertices can't be reach from the S then m
  ============================================================================================================================
  Time Complexity :- O(V*E)
  Space Complexity :- O(V)
 =================================================================================================================================
  class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
          Arrays.fill(dist,(int)(1e8));
        
        dist[S] = 0;
        
         //By Applying Bellaman's ford algorithm 
        //We Relax all V-1 edges sequentions
        for(int count = 0; count < V-1; count++)
        {
            for(ArrayList<Integer> edge : edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u] !=(int)(1e8) && dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
          //Again we loop through the edges to detect the negative cycle.
        //If dist[] values changes it means negative cycle was there.
        for(ArrayList<Integer> edge : edges)
        {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
            
            if(dist[u] !=(int)(1e8) && dist[u] + wt < dist[v])
            {
                return new int[]{-1};
            }
        }
     
        return dist;
    }
}
