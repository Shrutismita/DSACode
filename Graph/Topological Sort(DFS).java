Q:- https://www.geeksforgeeks.org/problems/topological-sort/1
  Topological Sort (DFS)
  Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and E  edges, your task is to find any valid topological sorting of the graph.

 

In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.
  ==============================================================================================================
  T.C:- O(V+E)
  S.C:- O(V)
=============================================Using DFS============================================================================
  class Solution
{
    static void DFS(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited,Stack<Integer> st )
    {
        visited[u] = true;
        //First adding u's children push in to stack
        for(Integer v : adj.get(u))
        {
            if(visited[v] == false)
            {
                DFS(adj,v,visited,st);
            }
        }
        
        st.push(u);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                DFS(adj,i,visited,st);
            }
        }
        //POP from stack
        int k = 0;
         while(!st.isEmpty()){
            result[k++] = st.pop();
        }
        return result;
    }
}
