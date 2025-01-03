Q:- https://leetcode.com/problems/build-a-matrix-with-conditions/
*******************************************************************************************
//Approach-1 (Topological Sorting using DFS)
//T.C : O(k*^2 + n)
//S.C : O(k*^2 + n)
-----------------------------------------
  class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderColumns = topoSort(colConditions, k);

        // We might have found cycle. That's why topo order is empty
        if (orderRows.isEmpty() || orderColumns.isEmpty())
            return new int[][]{};

        int[][] matrix = new int[k][k];
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(orderColumns.get(i), i);
        }

        for (int i = 0; i < k; i++) {
            int element = orderRows.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();
        int[] visited = new int[n + 1]; // 0: not visited, 1: visiting, 2: visited
        boolean[] hasCycle = {false};

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, stack, hasCycle);
                if (hasCycle[0])
                    return new ArrayList<>(); // no ordering possible
            }
        }

        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, int[] visited,
                     Stack<Integer> stack, boolean[] hasCycle) {
        visited[node] = 1; // Mark node as visiting

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adj, visited, stack, hasCycle);
            } else if (visited[neighbor] == 1) {
                hasCycle[0] = true; // Cycle detected
                return;
            }
        }

        visited[node] = 2; // Mark node as visited
        stack.push(node); // Add node to the stack
    }
}

=========================================================================================================
 //Approach-2 (Topological Sorting using BFS)
//T.C : O(k*^2 + n)
//S.C : O(k*^2 + n)
  ------------------------------------------
  class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
     List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderColumns = topoSort(colConditions, k);

        // We might have found cycle. That's why topo order is empty
        if (orderRows.isEmpty() || orderColumns.isEmpty())
            return new int[][]{};

        int[][] matrix = new int[k][k];
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(orderColumns.get(i), i);
        }

        for (int i = 0; i < k; i++) {
            int element = orderRows.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n + 1];
        List<Integer> order = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        // Push all integers with in-degree 0 in the queue.
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            
            for (int v : adj.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }

        if (count != n) 
            return new ArrayList<>(); // Cycle detected

        return order;
    }
}
