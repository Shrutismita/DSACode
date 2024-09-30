Q:-  https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1
===================================================================================
Time Complexity: O(V+E) where E is the number of edges in graph.
Space Complexity: O(V)
 =====================================================================================
  class Solution{
    private void DFS(List<Integer>[] adj, int u, boolean[] visited) {
        visited[u] = true;

        for (int i = 0; i < adj[u].size(); i++) {
            int neighbor = adj[u].get(i);
            if (!visited[neighbor]) {
                DFS(adj, neighbor, visited);
            }
        }
    }
    private boolean isConnected(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        // Find a vertex with non-zero degree
        int nonZeroDegreeVertex = -1;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() != 0) {
                nonZeroDegreeVertex = i;
                break;
            }
        }

        // Start DFS traversal from a vertex with non-zero degree
        DFS(adj, nonZeroDegreeVertex, visited);

        // Check if all non-zero degree vertices are visited
        for (int i = 0; i < V; i++) {
            if (!visited[i] && adj[i].size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    public int isEulerCircuit(int V,List<Integer>[] adj) 
    {
        // code here
    // Check if all non-zero degree vertices are connected
        if (!isConnected(V, adj)) {
            return 0; // Non-Eulerian
        }

        // Count vertices with odd degree
        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                oddCount++;
            }
        }

        // If count is more than 2, then graph is not Eulerian
        if (oddCount > 2) {
            return 0; // Non-Eulerian
        }

        if (oddCount == 2) {
            return 1; // Semi-Eulerian (It has only Euler Path)
        }

        return 2; // Euler Circuit
    }
}
