Q:- https://leetcode.com/problems/cheapest-flights-within-k-stops/
T.C : O(V+E) - BFS traversal of Graph
S.C : O(V+E)
============================================================================================================================
//Approach-1 (Dijkstra's Algorithm + BFS)
  class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n ;i++)
              adj.add(new ArrayList<>());
        for(int[] flight : flights)
        {
             int u = flight[0];
             int v = flight[1];
             int cost = flight[2];
              adj.get(u).add(new int[]{v,cost});
             
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;

        int level = 0;

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int d = current[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        queue.offer(new int[]{v, d + cost});
                    }
                }
            }
            level++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
