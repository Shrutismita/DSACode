Q:- https://leetcode.com/problems/min-cost-to-connect-all-points/
T.C:- O(E log V)
S.C:- O(V^2)
=======================================================================================================
  //Approach-1 (Using Priority_queue and Adjacency list representation of graph) - Prim's Algorithm
  
class Solution {
class Pair
{
    int cost;
    int node;
    Pair(int cost,int node)
    {
        this.cost = cost;
        this.node = node;
    }
}
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
           adj.add(new ArrayList<>());

        // Create an adjacency list to represent the graph
        for(int i = 0; i < V ; i++)
        {
          for(int j = i+1; j<V;j++)
          {
             int x1 = points[i][0];
             int y1 = points[i][1];

             int x2 = points[j][0];
             int y2 = points[j][1];
              
              int d = Math.abs(x1-x2)+ Math.abs(y1-y2);

              adj.get(i).add(new int[]{j,d});
              adj.get(j).add(new int[]{i,d});
            }   
        } 
          PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.cost-y.cost);

          pq.add(new Pair(0,0));// Add the first vertex with cost 0
          int sum = 0;

         // Prim's Algorithm to find the minimum cost to connect all points
          while(!pq.isEmpty())
          {
            Pair curr = pq.poll();
            int cost = curr.cost;
            int node = curr.node;
            // Skip if the vertex is already visited
             if(visited[node] == true) continue;

             visited[node] = true;// Mark the vertex as visited
             sum += cost; // Add the cost to the total cost

             // Iterate through neighbors of the current vertex
             for(int[] temp : adj.get(node))
             {
                int neighbour = temp[0];
                int neighbour_cost = temp[1];
                if(visited[neighbour] == false)
                {
                    pq.add(new Pair(neighbour_cost,neighbour));
                }
             }
          }
          return sum;
    }
}
