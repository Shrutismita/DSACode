Q:- https://practice.geeksforgeeks.org/problems/topological-sort/1
Topological sort
  Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and E  edges, your task is to find any valid topological sorting of the graph.

 

In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.
  =================================================================================================
  T.C:- O(V+E)
S.C:- O(V)
=======================================================BFS-Kahn's Algorithm==================================================
  class Solution
{
   
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        //step-1
        for(int u = 0; u < V; u++)
        {
           for(int v : adj.get(u))
           {
               indegree[v]++;
           }
        }
        //Fill Queue, indegree with 0
        for(int i = 0; i<V;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }
        //Simple BFS
        int[] result = new int[V];
        int k = 0;
         while(!queue.isEmpty())
         {
             int u = queue.poll();
              result[k++] = u;
              
              for(int v : adj.get(u))
              {
                  indegree[v]--;
                  if(indegree[v] == 0)
                  {
                      queue.add(v);
                  }
              }
         }
        return result;
    }
}
