Q:- https://leetcode.com/problems/network-delay-time/
T.C:- O(ElogV)
S.C:- O(E+V)
====================================Using Dijkstra's algorithm ================================================================
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
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i <= n; i++)
             adj.add(new ArrayList<>());
        for(int[] time : times)
        {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v,w});
        }
         
         PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);

        int[] result = new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);

        result[k] = 0;
        pq.add(new Pair(0,k));

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
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<=n ;i++)
              ans = Math.max(ans,result[i]);

        return ans == Integer.MAX_VALUE ? -1: ans;      
    }
}
