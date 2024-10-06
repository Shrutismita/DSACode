Q:- https://leetcode.com/problems/maximal-network-rank/
T.C:- O(V^2)
S.C:- O(V)
=================================================================================
  class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
               adj.add(new ArrayList<>());

          for(int[] road : roads)
          {
            int u = road[0];
            int v = road[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
          }     
          int result = 0;
          if(roads.length == 0) return result;
          for(int i = 0; i < n; i++)
          {
            for(int j = 0; j < n; j++)
            {
                if(i == j)continue;
                 //check if connected
                 if(adj.get(i).contains(j) == true)
                 {
                    result = Math.max(result, adj.get(i).size() + adj.get(j).size() - 1);
                 }
                 else
                 {
                    result = Math.max(result,adj.get(i).size() + adj.get(j).size());
                 }
            }
          }
          return result;
    }
}
