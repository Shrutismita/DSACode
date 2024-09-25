Q:- https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1
  Detect Cycle using DSU
Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, the task is to check if there is any cycle in the undirected graph.

Note: Solve the problem using disjoint set union (DSU).
=====================================================================================
  T.C:- O(V+E)
S.C:- O(V)
===================================================================================
  class Solution
{
    int[] parent;
    int[] rank;
    
     int find(int x)
     {
         if(parent[x] == x)
              return x;
        
        return parent[x] = find(parent[x]);       
     }
     void Union(int x,int y)
     {
         int x_parent=find(x);
         int y_parent = find(y);
         
          if(x_parent == y_parent)
               return ;
          if(rank[x_parent] > rank[y_parent])
          {
              parent[y_parent] = x_parent;
          }
          else if(rank[x_parent] < rank[y_parent])
          {
              parent[x_parent] = y_parent;
          }
          else
          {
              parent[x_parent] = y_parent;
              rank[y_parent]++;
          }
          
     }
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        	parent = new int[V];
		    rank = new int[V];

		for (int i = 0; i < V; i++)
		{
			parent[i] = i;
			rank[i] = 1;
		}
			
		for(int u = 0; u < V; u++)
		{
		    for(int v : adj.get(u))
		    {
		        // Since the edges are bi-directional we are only considering them from the smaller to the larger node. 
		        //And ignoring the edge from larger to smaller node to eliminate duplicate calculation.
		        if(u < v)
		        {
		            if(find(u) == find(v))
		            {
		                  return 1;
		            }
		            else
		            {
		                Union(u,v);
		            }
		              
		        }
		    }
		}
        return 0;
    }
}
