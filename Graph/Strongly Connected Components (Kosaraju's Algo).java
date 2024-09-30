Q:-https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

===========================================================================================================
Time Complexity: O(V+E)
Space Complexity: O(V+E)
===============================================================================================================
  //Kosaraju's Algorithm 
  class Solution {
    // Function to find the number of strongly connected components in the graph
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Perform a DFS on the original graph to find the finishing order of vertices
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        // Fill the vertices in stack according to their finishing times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        
        // Step 2: Create a transposed graph
       
          ArrayList<ArrayList<Integer>> transpose = new ArrayList<>(V);
        
        // Initialize the transpose graph with empty lists
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        
        // Reverse the edges to form the transpose graph
        for (int v = 0; v < V; v++) {
            for (int neighbor : adj.get(v)) {
                transpose.get(neighbor).add(v);
            }
        }
        
        // Step 3: Perform DFS on the transposed graph in the order of the vertices in the stack
        Arrays.fill(visited, false);
        int count = 0;  // Strongly connected components count
        
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                // Perform DFS for the current component
                dfsTranspose(v, transpose, visited);
                count++;
            }
        }
        
        return count;
    }
    
    // Helper function to perform DFS and push nodes to stack based on their finishing times
    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        
        // All vertices reachable from v are processed, now push v to stack
        stack.push(v);
    }
    
    // Helper function to perform DFS on the transposed graph
    private void dfsTranspose(int v, ArrayList<ArrayList<Integer>> transpose, boolean[] visited) {
        visited[v] = true;
        
        for (int neighbor : transpose.get(v)) {
            if (!visited[neighbor]) {
                dfsTranspose(neighbor, transpose, visited);
            }
        }
    }
    
    
}
