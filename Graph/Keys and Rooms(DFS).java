Q:- https://leetcode.com/problems/keys-and-rooms/
T.C:- O(m+n)
S.C:- O(n)
=================================================================================
  //Using DFS 
  -------------
  class Solution {
    void dfs(List<List<Integer>> rooms, int u, boolean[] visited)
    {
        visited[u] = true;
        for(int node : rooms.get(u))
        {
            if(visited[node] == false)
            {
                dfs(rooms,node,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms,0,visited);

        for(boolean x : visited)
        {
            if(x == false)
                return false;
        }
        return true;
    }
}
