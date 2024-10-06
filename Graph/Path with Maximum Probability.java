Q:- https://leetcode.com/problems/path-with-maximum-probability/
T.C : O(E*log(V))
S.C : O(V + E)
===================================================================
  //Using Dijkstra's Algorithm
  -------------------------------
  class Solution {
    class Pair
    {
        int v;
        double success;
        Pair(int v, double success)
        {
            this.v = v;
            this.success = success;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
         {
              adj.add(new ArrayList<>());
         }
         for(int i = 0; i < succProb.length ; i++)
         {  
            int u = edges[i][0];
            int v = edges[i][1];
            double pathProb = succProb[i];          
            adj.get(u).add(new Pair(v,pathProb));
            adj.get(v).add(new Pair(u,pathProb));
         }
         // Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.success, a.success));
         pq.add(new Pair(start_node,1.0));

         while(!pq.isEmpty())
         {
             Pair cur = pq.poll();
             double curProb = cur.success;
             int curNode = cur.v;
            // If the current node is the end node, return the probability
            if (curNode == end_node) {
                return curProb;
            }
             // Explore the neighbors
             for(Pair neigh : adj.get(curNode))
             {
                 int nxtNode = neigh.v;
                 double pathProb = neigh.success;
                  // Update the probability if a higher one is found
                if (curProb * pathProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = curProb * pathProb;
                    pq.add(new Pair(nxtNode,maxProb[nxtNode]));
                }
             }
         }
       return 0.0;  
    }
}
