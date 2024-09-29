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
=======================================================================================================================================
  //Approach-2 (Using Kruskal's Algorithm)
  
class Solution {
      int[] parent;
      int[] rank;
      int find(int x)
      {
        if(x == parent[x])
              return x;

        return parent[x] = find(parent[x]);      
      }
      void Union(int x, int y)
      {
        int parent_x = find(x);
        int parent_y = find(y);

        if(parent_x == parent_y)
              return;

        if(rank[parent_x] > rank[parent_y])
        {
            parent[parent_y]=parent_x;
        }
        else if(rank[parent_x] < rank[parent_y])
        {
            parent[parent_x]=parent_y;
        }
        else
        {
             parent[parent_x]=parent_y;
             rank[parent_y]++;
        }
      }
      int Kruskal( List<int[]> adj)
      {
        int sum = 0;
        for(int[] temp : adj)
        {
            int u = temp[0];
            int v = temp[1];
            int wt = temp[2];

            if(find(u) != find(v))
            {
                sum += wt;
                Union(u,v);
            }
        }
        return sum;
      }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<int[]> adj = new ArrayList<>();
        parent = new int[V];
        rank = new int[V];
        for(int i = 0; i < V; i++)
           {
            parent[i] = i;
            rank[i] = 1;
           }

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

              adj.add(new int[]{i,j,d});
              
            }   
        } 
          Collections.sort(adj,(a,b) -> a[2] - b[2]);
           return Kruskal(adj);
    }
}
  
