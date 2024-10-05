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
=================================================================================
    //Approach-2 : Using BFS
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
    void bfs(List<List<Integer>> adj, int u, boolean[] visited)
    {
        Queue<Integer> que = new LinkedList<>();
         visited[u] = true;
        que.add(u);
        while(!que.isEmpty()) {
            
            int curr = que.poll();
           
            
            for(int v : adj.get(curr)) {
                if(!visited[v]) {
                    que.add(v);
                    visited[v] = true;
                }
            }
            
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
                bfs(adj,i,visited);
                count++;
            }
         }
         return count;
    }
}
=======================================================================================
  //Approach -3 : Using DSU
--------------------------------
  class Solution {
    int[] parent;
    int[] rank;
    int find(int x)
    {
        if(x == parent[x])
             return x;

         return parent[x] = find(parent[x]);    
    }
    void Union(int x, int y)
    {
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent)
             return;

        if(rank[x_parent] > rank[y_parent])   
             parent[y_parent]  = x_parent;

         else if(rank[x_parent] < rank[y_parent]) 
               parent[x_parent]  = y_parent;
          else
          {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }

    }
     boolean isSimilar(String s1, String s2) {
        
        int n = s1.length();
        int diff = 0;
        for(int i = 0; i<n; i++) {
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        
        return diff == 2 || diff == 0;
    }
    
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
           parent= new int[n];
           rank = new int[n];
           for(int i = 0 ; i < n; i++)
                 parent[i]= i;
        int groups = n; //Initially all strings represent themselves
         for(int i = 0; i < n;i++)
         {
            for(int j = i +1; j < n ; j++)
            {
                 if(isSimilar(strs[i], strs[j]) && find(i) != find(j)) 
                 {
                     groups--;
                    Union(i, j);
                }
            }
         }        
         return groups;
    }
}
