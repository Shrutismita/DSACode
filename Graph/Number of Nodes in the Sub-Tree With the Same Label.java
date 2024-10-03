Q:- https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  //Approach (Using DFS)
  ------------------------------
  class Solution {
    void DFS(List<List<Integer>> adj,int curr_node, int parent_node,int[] result,int[] count, String labels)
    {
          char myLabels =  labels.charAt(curr_node);
          int count_before_visiting_curr_children = count[myLabels - 'a'];
          count[myLabels - 'a'] += 1;
          for(int v: adj.get(curr_node))
          {
            if(v == parent_node) continue;
            DFS(adj,v,curr_node,result,count,labels);
          }

          int count_after_visiting_curr_children = count[myLabels - 'a'];
          result[curr_node] = count_after_visiting_curr_children - count_before_visiting_curr_children;

    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++ )
                  adj.add(new ArrayList<>());

         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];
             adj.get(v).add(u);
             adj.get(u).add(v);
         } 
         int[] result = new int[n];
         int[] count = new int[26];


         DFS(adj,0,-1,result,count,labels);

         return result;     
    }
   }
