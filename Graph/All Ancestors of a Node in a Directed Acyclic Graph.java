Q:- https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
********************************************************************************************
//Approach-1 (Using DFS)
//T.C : O(n * (n+m)) , n = number of vertices and m = number of edges
//S.C : O(n+m)
-------------------------------------------------------
  class Solution {
    void dfs(List<List<Integer>> adj,int ancestor, int currNode,  List<List<Integer>> result)
    {
        for (int ngbr : adj.get(currNode)) {
            if (result.get(ngbr).isEmpty() || result.get(ngbr).get(result.get(ngbr).size() - 1) != ancestor) { // to avoid duplicate entry
                result.get(ngbr).add(ancestor);
                dfs(adj, ancestor,ngbr, result);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
         List<List<Integer>> result = new ArrayList<>();
         List<List<Integer>> adj = new ArrayList<>();
         for(int i =0; i<n;i++)
            adj.add(new ArrayList<>());

         for(int[]  edge:  edges)
         {
            int u =  edge[0];
            int v =  edge[1];

            adj.get(u).add(v);
           
         }   
         for(int i = 0;i < n; i++)
             result.add(new ArrayList<>());

         for(int i = 0 ; i <n ;i++)
         {
            dfs(adj,i,i,result);
         }
          return result;    
    }
}
