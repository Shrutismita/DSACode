Q:- https://leetcode.com/problems/parallel-courses-iii/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  //Approach-1 (Using Simple Topological sorting)
  --------------------------------------------------
  class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        int[] maxTime = new int[n];
        for(int i = 0; i < n; i++)
             adj.add(new ArrayList<>());
        for (int[] relation : relations) 
        {
             int u = relation[0] - 1;
             int v = relation[1] - 1;

            adj.get(u).add(v);
            indegree[v]++;
        }
          Queue<Integer> queue = new LinkedList<>();
         for (int i = 0; i < n; i++) 
        {
            if (indegree[i] == 0) 
            {
                queue.offer(i);
                maxTime[i] = time[i];
            }
        }

        while(!queue.isEmpty())
        {
            int u = queue.poll();
            for(int v : adj.get(u))
            {
                 maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v]);
                indegree[v]--;
                if (indegree[v] == 0) 
                {
                    queue.offer(v);
                }
            }
        }
         int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxTime[i]);
        }
        
        return result;
    }
}
