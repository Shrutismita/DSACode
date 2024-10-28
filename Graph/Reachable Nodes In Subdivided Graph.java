Q:- https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/
*********************************************************************************
//Using  Dijkstra and PriorityQueue
//Time complexity:O(V+E)log(V), where V is the no. of vertices and E is the no. of edges. V + E is for traversing the graph and log factor for priorityQueue (minHeap).
//Space complexity: O(V+ E)
---------------------------------------------------------------
  class Solution {
    class Pair
    {
        int node;
        int wt;
        Pair(int node, int wt)
        {
            this.node = node;
            this.wt = wt;
        }
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // create adjacency list and distance array
        List<List<int[]>> adj = new ArrayList<>();

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
          // use Dijkstra's algorithm to calculate distance
           PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
           pq.add(new Pair(0,0));
           dist[0] = 0;
           while(!pq.isEmpty())
           {
              Pair curr = pq.poll();
              int node = curr.node;
              int distance = curr.wt;
               if (distance > dist[node]) 
                {
                    continue;
                }

                for(int[] next : adj.get(node))
                {
                    int neighbor = next[0];
                    int neighbor_dist = next[1];
                    int newDistance = distance + neighbor_dist + 1;
                    if(newDistance < dist[neighbor])
                    {
                        dist[neighbor] = newDistance;
                        pq.add(new Pair(neighbor, newDistance));
                    }
                }
           }
         
             // count reachable nodes
             int count = 0;
             for (int d : dist) 
             {
                  if (d <= maxMoves) 
                  {
                       count++;
                   }
             }

             for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            int du = dist[u];
            int dv = dist[v];
            int reachable = Math.max(0, maxMoves - du) + Math.max(0, maxMoves - dv);
            count += Math.min(cnt, reachable);
        }

        return count;
    }
}
