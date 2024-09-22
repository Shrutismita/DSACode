Q: - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
  
Undirected Graph Cycle
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

Examples:

Input: V = 5, E = 5
adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]] 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.

  ===============================================================================================================================================================================
  T.C:- O(V+E)
  S.C:- O(V)
=================================================================-----Using DFS------=====================================================
  Appraoch - 1
  --------------------
  class Solution {
    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited, int parent)
    {
        // Mark the current node as visited
        visited[u] = true;
        // Check all adjacent vertices
        for(Integer v : adj.get(u))
        {
            if(v == parent) continue;
            if(visited[v] == true)
                 return true;
            if(isCycleDFS(adj,v,visited,u) == true)
                return true;
        }
        return false;
    
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // To keep track of visited vertices
         boolean[] visited = new boolean[V];  
        for (int i = 0; i < V; i++) {
            if(visited[i] == false && isCycleDFS(adj,i,visited,-1))
            {
                return true;
            }
        }
        return false;
        
        
    }
}

============================================================= ----Using BFS---- ========================================================================
Approach -2
  ---------------------
  class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited)
    {
         Queue<Pair> queue = new LinkedList<>();
         queue.add(new Pair(u,-1));
         // Mark the current node as visited
         visited[u] = true;
        
        while(!queue.isEmpty())
        {
            Pair p = queue.poll();
            int source = p.first;
            int parent = p.second;
            // Check all adjacent vertices
            for(Integer v : adj.get(source))
            {
                 if(visited[v] == false)
                 {
                      visited[v] = true;
                      queue.add(new Pair(v,source));
                 }
                 else if( v != parent)
                 {
                     return true;
                 }
            }
        
        }
        
        return false;
    
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
       
        // To keep track of visited vertices
         boolean[] visited = new boolean[V];  
        for (int i = 0; i < V; i++) {
            if(visited[i] == false && isCycleBFS(adj,i,visited))
            {
                return true;
            }
        }
        return false;
        
        
    }
}
  
