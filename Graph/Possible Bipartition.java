Q:- https://leetcode.com/problems/possible-bipartition/
T.C:- O(V+E)
S.C:- O(V)
====================================================================================================
  Approach - 1: Using BFS
  ------------------------------
  class Solution {
    boolean isBipartite(List<List<Integer>> adj, int node, int[] color)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;
        while(!queue.isEmpty())
        {
            int u = queue.poll();
            for(int v : adj.get(u))
            {
                if(color[u] == color[v])
                     return false;
                if(color[v] == -1)
                {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }     
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=n;i++)
            adj.add(new ArrayList<>());

        for(int[] dislike : dislikes)
        {
            int u = dislike[0];
            int v = dislike[1];

            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i =1;i<=n; i++)
        {
            if(color[i] == -1)
            {
                if(!isBipartite(adj,i,color))
                     return false;
            }
        }
        return true;
    }
}
===================================================================================================
  Approach - 2 Using DFS
  -------------------------
  class Solution {
    boolean isBipartiteDfs(List<List<Integer>> adj, int curr, int currColor,int[] color)
    {        
        color[curr] = currColor;
            for(int v : adj.get(curr))
            {
                if(color[curr] == color[v])
                     return false;
                if(color[v] == -1)
                {
                    int colorV = 1 - currColor;
                    if(isBipartiteDfs(adj,v,colorV,color) == false)
                         return false;
                }     
            }
        
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=n;i++)
            adj.add(new ArrayList<>());

        for(int[] dislike : dislikes)
        {
            int u = dislike[0];
            int v = dislike[1];

            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i =1;i<=n; i++)
        {
            if(color[i] == -1)
            {
                if(!isBipartiteDfs(adj,i,1,color))
                     return false;
            }
        }
        return true;
    }
}
