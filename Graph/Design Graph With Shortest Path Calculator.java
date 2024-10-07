Q:- https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

=================================================================================
  //Approach-1 (Using Dijkstra's Algorithm)
  T.C:- T.C : Dijkatra's called M times - O(M * ElogV)
   S.C:- O(V)
  -------------------------------------------
  class Graph {
    private List<List<Node>> adj;

    public Graph(int n, int[][] edges) {
         adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
             adj.add(new ArrayList<>());

         for(int[] edge: edges) 
         {
            addEdge(edge);
         }   
    }
    
    public void addEdge(int[] edge) {
         int u = edge[0];
         int v = edge[1];
         int cost = edge[2];

         adj.get(u).add(new Node(v,cost));
    }
    
    public int shortestPath(int node1, int node2) {
         int[] result = new int[adj.size()];
         Arrays.fill(result, Integer.MAX_VALUE);
          PriorityQueue<Node> pq = new PriorityQueue<>((x,y)-> x.cost - y.cost);
        result[node1] = 0;
        pq.add(new Node(node1, 0));
        while(!pq.isEmpty())
        {
            Node n = pq.poll();
            int node = n.node;
            int d = n.cost;
            for (Node nei : adj.get(node))
            {
                 int adjNode = nei.node;
                  int dist = nei.cost;
                  if(d+dist < result[adjNode])
                  {
                    result[adjNode] = d + dist;
                    pq.add(new Node(adjNode, d + dist));
                  }
            }
        }
         return result[node2] == Integer.MAX_VALUE ? -1 : result[node2];
    }
    class Node
    {
        int node;
        int cost;
        Node(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }
    }
}

***********************************************************************************************
  //Approach-2 (Using Floyd Warshal Algorithm)
//T.C : O(N^3) - Making adj Matrix
  -------------------------------------
  class Graph {
    // Floyd-Warhsall Algorithm
    int N;
    int[][] adj;
    int INT_MAX = 1000000000;
    public Graph(int n, int[][] edges) {
         N = n;
          adj = new int[n][n];
         for(int i = 0; i < n; i++)
         {
             Arrays.fill(adj[i], INT_MAX);
             adj[i][i] = 0;
         }
            

         for(int[] edge: edges) 
         {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

             adj[u][v] = w;
         }   
          // Floyd Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
         int u = edge[0];
         int v = edge[1];
         int cost = edge[2];

        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                adj[i][j] = Math.min(adj[i][j], adj[i][u] + cost + adj[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
         return adj[node1][node2] == INT_MAX ? -1 : adj[node1][node2];
        }
        
    }
   
