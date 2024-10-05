Q:- https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  class Solution {
     int result = Integer.MAX_VALUE;
     void dfs(HashMap<Integer, List<List<Integer>>> graph, int u, boolean[] visited)
     {
        visited[u] = true;
        if(!graph.containsKey(u))
        {
            return ;
        }
        for(List<Integer> neighbor : graph.get(u))
        {
            int v = neighbor.get(0);
            int dist = neighbor.get(1);
            result = Math.min(result,dist);
            if(visited[v] == false)
            {
                dfs(graph, v,visited);
            }
        }
    }
  public int minScore(int n, int[][] roads) {
     HashMap<Integer, List<List<Integer>>> graph = new HashMap<>();

        for(int[] it : roads)
        {
            graph.computeIfAbsent(it[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(it[1],it[2]));

            graph.computeIfAbsent(it[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(it[0],it[2]));
        }

        boolean[] visited = new boolean[n+1];

        dfs(graph,1, visited);

        return result;

    }

  
}
