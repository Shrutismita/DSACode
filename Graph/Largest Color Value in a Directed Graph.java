Q:- https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
T.C:- O(26N) 
S.C:- O(N)
=================================================================================
  //Approach-1 (Using Topological Sorting with BFS)
  --------------------------------------------------
  class Solution {
    public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            List<List<Integer>> adj = new ArrayList<>();
           for(int i = 0; i < n;i++)
                 adj.add(new ArrayList<>());

            int[] indegree = new int[n];
            for(int[] edge : edges)
            {
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
                indegree[v]++;
            }
            int[] values = new int[n];
            Arrays.fill(values, 1);
            // applying kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        final int[][] count = new int[n][26];
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
                count[i][colors.charAt(i) - 'a']++;
            }
        }
        int nodesSeen = 0;
        int result = Integer.MIN_VALUE;
        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            nodesSeen++;
        result = Math.max(result, Arrays.stream(count[node]).max().getAsInt());
            for (int neighbor : adj.get(node)) {
                // by traversing through which color to this node: will give the max. value
                for (int i = 0; i < 26; ++i) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]
                            + (i == colors.charAt(neighbor) - 'a' ? 1 : 0));
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return nodesSeen != n ? -1 : result;
    }
}
  
