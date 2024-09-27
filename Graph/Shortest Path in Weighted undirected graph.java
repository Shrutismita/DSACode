Q:- https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
  
  Shortest Path in Weighted undirected graph

You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,  if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1.
  =========================================================================================================================
T.C:- O(m * log(n))
S.C:- O(n+m)
====================================================================================================================
  class Pair
{
    
    int distance;
    int node;
    Pair(int distance,int node)
    {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
              adj.add(new ArrayList<>());
              
         for(int[] edge : edges)
         {
             int u = edge[0];
             int v = edge[1];
             int w = edge[2];
             
             adj.get(u).add(new int[]{v,w});
             adj.get(v).add(new int[]{u,w});
         }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) ->x.distance - y.distance);
        
        int[] result = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
       
         result[1] = 0;
         pq.add(new Pair(0,1));
         
         while(!pq.isEmpty())
         {
                Pair p = pq.poll();
                int d = p.distance;
                int node = p.node;
                
                for(int[] current : adj.get(node))
                {
                    int adjNode = current[0];
                    int dist = current[1];
                    
                    if(d+dist < result[adjNode])
                    {
                        result[adjNode] = d+dist;
                        pq.add(new Pair(result[adjNode],adjNode));
                        parent[adjNode] = node;
                    }
                }
         }
         
         List<Integer> path = new ArrayList<>();
         int node = n;
         
         if(result[node] == Integer.MAX_VALUE)
         {
              path.add(-1);
            return path;
         }
         
       
          for (int i = n; i != -1; i = parent[i]) 
          {
            path.add(i);
          }
        
         Collections.reverse(path);
         path.add(0,result[node]);
         return path;
        
    }
}
  
  
  
