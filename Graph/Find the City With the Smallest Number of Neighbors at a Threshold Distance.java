Q:- https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
***********************************************************************************************************************
//Approach -1 (Using Bellman-Ford)
//T.C : O(V * (V * E)) where E is the number of edges and V = number of vertices. We call Bellman(V*E) for each vertex.
        //In worst case , max edges = V*(V-1)/2
        //O(V * V*(V-1)/2 * log V)
        //Which is approximately equal to O(V^4)
//S.C : O(V^2)
 ---------------------------------------------------------------
  class Solution {
    // Bellman-Ford algorithm to find shortest paths from a source city
    void bellmanFord(int n, int[][] edges, int[] shortestPathDistances, int source) {
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE);
        shortestPathDistances[source] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (shortestPathDistances[u] != Integer.MAX_VALUE && 
                    shortestPathDistances[u] + wt < shortestPathDistances[v]) {
                    shortestPathDistances[v] = shortestPathDistances[u] + wt;
                }
                // Bi-directional edge
                if (shortestPathDistances[v] != Integer.MAX_VALUE && 
                    shortestPathDistances[v] + wt < shortestPathDistances[u]) {
                    shortestPathDistances[u] = shortestPathDistances[v] + wt;
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE);
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            shortestPathMatrix[u][v] = wt;
            shortestPathMatrix[v][u] = wt;
        }

        // Compute shortest paths from each city using Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
}
===============================================================================================
//Approach-2 (Using Floyd Warshall)
//T.C : O(V^3)
//S.C : O(V^2)
------------------------------------------------------
  class Solution {
    // Floyd-Warshall algorithm to find shortest paths between all pairs of cities
    void floydWarshall(int n, int[][] shortestPathMatrix) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestPathMatrix[i][j] = Math.min(shortestPathMatrix[i][j],
                                                        shortestPathMatrix[i][via] + shortestPathMatrix[via][j]);
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize the shortest path matrix with large values
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], (int) 1e9 + 7);
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            shortestPathMatrix[u][v] = wt;
            shortestPathMatrix[v][u] = wt;
        }

        // Compute shortest paths using Floyd-Warshall algorithm
        floydWarshall(n, shortestPathMatrix);

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
}
==================================================================================================
//Approach-3 (Using Dijkstra's)
//T.C : O(V * ElogV) where E is the number of edges and V = number of vertices. We call Dijkstra's for each vertex.
        //In worst case , max edges = V*(V-1)/2
        //O(V * V*(V-1)/2 * log V)
        //Which is approximately equal to O(V^3 * log V)
//S.C : O(V^2)
---------------------------------------------------------------------------------
  class Solution {
     // Dijkstra's algorithm to find shortest paths from a source city
    void dijkstra(int n, Map<Integer, List<int[]>> adj, int[] result, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, S});
        Arrays.fill(result, Integer.MAX_VALUE);
        result[S] = 0;  // Distance to source itself is zero

        // Process nodes in priority order
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            if (adj.get(node) == null) continue;  // Check if adjacency list is null

            for (int[] p : adj.get(node)) {
                int adjNode = p[0];
                int dist = p[1];

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.add(new int[] {d + dist, adjNode});
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        int[][] shortestPathMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE);
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[] {end, weight});
            adj.computeIfAbsent(end, k -> new ArrayList<>()).add(new int[] {start, weight});
        }

        // Compute shortest paths from each city using Dijkstra's algorithm
        for (int i = 0; i < n; i++) {
            dijkstra(n, adj, shortestPathMatrix[i], i);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
}
