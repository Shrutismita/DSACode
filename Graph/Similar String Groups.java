Q:- https://leetcode.com/problems/similar-string-groups/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  //Approach-1 : Using DFS
  ---------------------------
  class Solution {
     boolean isSimilar(String s1, String s2) {
        
        int n = s1.length();
        int diff = 0;
        for(int i = 0; i<n; i++) {
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        
        return diff == 2 || diff == 0;
    }
    void dfs(List<List<Integer>> adj, int u, boolean[] visited)
    {
         visited[u] = true;
        
        for(int v : adj.get(u)) {
            if(!visited[v])
                dfs(adj, v,visited);
        }
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n;i++)
              adj.add(new ArrayList<>());
         for(int i = 0; i < n;i++)
         {
            for(int j = i +1; j < n ; j++)
            {
                 if(isSimilar(strs[i], strs[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
         }

         boolean[] visited = new boolean[n];
         int count = 0;
         for(int i = 0; i < n;i++)
         {
            if(!visited[i])
            {
                dfs(adj,i,visited);
                count++;
            }
         }
         return count;
    }
}
