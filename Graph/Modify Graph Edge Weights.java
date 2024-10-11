Q:- https://leetcode.com/problems/modify-graph-edge-weights/
******************************************************************************
//Using Dijkstra for Shortest Path
//T.C : O(E * E * Log(V)) //E = number of edges, V = number of vertices/nodes
//S.C : O(V+E)
---------------------------------------------------------------------------------
  class Solution {
      private static final int LARGE_VALUE = (int) 2e9;

    private long dijkstraAlgorithm(int[][] edges, int n, int src, int dest) {
        // Construct the graph, excluding edges with -1 weight
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, wt});
                adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, wt});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        long[] result = new long[n];
        Arrays.fill(result, Integer.MAX_VALUE); // Fill result array with max value

        result[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int currNode = current[1];

            if (!adj.containsKey(currNode)) continue;

            for (int[] neighbor : adj.get(currNode)) {
                int nbr = neighbor[0];
                int wt = neighbor[1];

                if (result[nbr] > currDist + wt) {
                    result[nbr] = currDist + wt;
                    pq.add(new int[]{(int) result[nbr], nbr});
                }
            }
        }

        return result[dest];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long currShortestDist = dijkstraAlgorithm(edges, n, source, destination);

        if (currShortestDist < target) {
            return new int[][]{};
        }

        boolean matchedTarget = (currShortestDist == target);

        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = matchedTarget ? LARGE_VALUE : 1; // Assign lowest number i.e. 1

                if (!matchedTarget) {
                    long newShortestDist = dijkstraAlgorithm(edges, n, source, destination);

                    if (newShortestDist <= target) {
                        matchedTarget = true;
                        edge[2] += (target - newShortestDist);
                    }
                }
            }
        }

        if (!matchedTarget) {
            return new int[][]{};
        }
        return edges;
    }
}
