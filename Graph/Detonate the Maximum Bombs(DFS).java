Q:- https://leetcode.com/problems/detonate-the-maximum-bombs/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  class Solution {
     int dfs(Map<Integer,ArrayList<Integer>> adj , int source,boolean[] visited)
    {
        visited[source] = true;
        int res = 1;
        for(int item : adj.get(source))
        {
            if(visited[item] == false)
            {
                res += dfs(adj,item,visited);
            }
        }
        return res;
    }
    public int maximumDetonation(int[][] bombs) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < bombs.length; i++)
        {
            ArrayList<Integer> arr = new ArrayList<>();
            map.put(i,arr);
        }
        for(int i = 0; i < bombs.length; i++)
        {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            for(int j = 0; j < bombs.length;j++)
            {
                if(i != j)
                {
                    long x2 = bombs[j][0];
                    long y2 = bombs[j][1];
                    if(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) <= r1*r1)
                    {
                        ArrayList<Integer> arr = map.get(i);
                        arr.add(j);
                        map.put(i,arr);
                    }
                }
            }
        }
        int result = 1;
        for(int i = 0; i < bombs.length; i++)
        {
            boolean[] visited = new boolean[bombs.length];
            result = Math.max(result, dfs(map,i,visited));
        }
        return result;
        
    }
}
