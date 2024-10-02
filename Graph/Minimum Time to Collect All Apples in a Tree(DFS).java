Q:- https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  class Solution {
    int DFS( List<List<Integer>> adj ,int curr, int parent,List<Boolean> hasApple)
    {
        int time = 0;
        for(int child :adj.get(curr))
        {
            if(child == parent) continue;

            int time_from_child = DFS(adj,child,curr,hasApple);
            if(time_from_child > 0 || hasApple.get(child) == true)
                time += 2 + time_from_child;
        }
        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++)
            adj.add(new ArrayList<>());

         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            adj.get(u).add(v);
         }   
          return DFS(adj, 0, -1, hasApple);
    }
}
