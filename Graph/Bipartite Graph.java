Q:- https://leetcode.com/problems/is-graph-bipartite/
T.C:- O(V+E)
S.C:- O(V)
==========================================================================================================================
  //Approach-1 (Graph coloring : DFS)
  class Solution {
    boolean checkBipartiteDFS(int[][] adj,int curr,int[] color, int currColor)
    {
        color[curr] = currColor; //put color for curr node
        //now we are going to adjacent nodes
        for(int v : adj[curr])
        {
            if(color[v] == color[curr])
                 return false;
            if(color[v] == -1) //never colored (never visited)
            {
                 int colorOfV = 1 - currColor;
                 if(checkBipartiteDFS(adj, v, color, colorOfV) == false)
                     return false;
            }     
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
         //red = 1
	      //green = 0
        for(int i = 0; i < n;i++)
        {
            color[i] = -1;//no node colored in the start
        }
        for(int i = 0; i < n; i++)
        {
            if(color[i] == -1)
            {
                 if(checkBipartiteDFS(graph,i,color,1) == false)
                    return false;
            }
        }
        return true;
    }
}
====================================================================================================================
  //Approach-2 (Graph coloring : BFS)
class Solution {
    boolean checkBipartiteBFS(int[][] adj, int curr, int[] color, int currColor)
    {
        color[curr] = currColor;
         Queue<Integer> que = new LinkedList<>();
         que.add(curr);
         while(!que.isEmpty())
         {
            int u = que.poll();
            for(int v : adj[u])
            {
                if(color[v] == color[u])
                     return false;
                if(color[v] == -1) //never colored (never visited)
                {
                    color[v] = 1 - color[u];
                    que.add(v);
                }     
            }
         }
         return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
         //red = 1
	     //green = 0
        for(int i =0; i < n; i++)
        {
            color[i] = -1; //no node colored as of now
        }
        for(int i = 0; i < n; i++)
        {
            if(color[i] == -1)
            {
                if(checkBipartiteBFS(graph,i,color,1) == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
  
  
