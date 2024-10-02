Q:- https://leetcode.com/problems/sum-of-distances-in-tree/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  Using DFS
  -----------------
  class Solution {
    //store count of subtrees of each node
    int result_base_node = 0;
    int[] count;
    int N;
    int dfsBase(List<List<Integer>> adj,int curr_node, int prev_node, int curr_depth) 
    {
         int total_node = 1;        
         result_base_node += curr_depth;

         for(int child : adj.get(curr_node))
         {
            if(child == prev_node) continue;
            total_node += dfsBase(adj, child, curr_node, curr_depth+1);
         }
         //store count of subtrees of each node
        count[curr_node] = total_node;
        
        return total_node;
    }
    void DFS(List<List<Integer>> adj, int parent_node, int prev_node,int[] result)
    {
       for(int child : adj.get(parent_node))
       {
           if(child == prev_node) continue;
            result[child] = result[parent_node] - count[child] + (N - count[child]);
            DFS(adj, child, parent_node, result);
       }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        N = n;
        count = new int[n];
        Arrays.fill(count,0);

        for(int i = 0; i < n; i++)
              adj.add(new ArrayList<>());

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            adj.get(u).add(v);
        }

         result_base_node = 0;
         dfsBase(adj,0,-1,0);

         int[] result = new int[n];
         result[0] = result_base_node;
         DFS(adj, 0, -1, result);
        
        return result;

        
    }
}
