Q:- https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  class Solution {
    int count = 0;
    void dfs(List<List<int[]>> adj,int curr_node,int parent, boolean[] visited)
    {
        visited[curr_node] = true;

        for(int[] child : adj.get(curr_node))
        {
            int child_node = child[0];
            int sign = child[1];
            if(visited[child_node] == false)
            {
                count += sign;
                dfs(adj,child_node,curr_node,visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++)
             adj.add(new ArrayList<>());

        for(int[] connection : connections)
        {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }

        boolean[] visited = new boolean[n];
        
        dfs(adj,0,-1,visited);

        return count;
    }
}
