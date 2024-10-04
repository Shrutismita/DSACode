Q:- https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
=====================================================================================
//Approach-1 (DFS)
  T.C:- O(V+E)
  S.C:- O(V)
-------------------
  class Solution {
    char DFS( ArrayList<Character>[] adj , char currChar, int[] visited)
    {
          // since we have visited this letter (currChar), we mark it so we don't visit it again 
        visited[currChar - 'a'] = 1;   
        char minChar =  currChar;
        for(char v : adj[currChar - 'a'])
        {
             if(visited[v-'a'] == 0)  // if it wasn't visited already, we do some work
                minChar =(char) Math.min(minChar, DFS(adj, v, visited));
        }
        return minChar;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        ArrayList<Character>[] adj = new ArrayList[26];
        for(int i = 0; i < 26; i++)
              adj[i] = new ArrayList<Character>();

        for(int i = 0; i < n; i++)
        {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj[u - 'a'].add(v);
            adj[v - 'a'].add(u);
        }
        int m = baseStr.length();
         StringBuilder result = new StringBuilder();     // to store the answer string;
        for(int i = 0; i<m; i++) {
            char ch = baseStr.charAt(i);
            
           int[]  visited = new int[26];
            Arrays.fill(visited,0);
            result.append(DFS(adj, ch, visited));
        }
        
        return result.toString();
    }
}
=======================================================================================
  //Approach-2 (DSU)
  T.C:- O(V+E Log(E))
  S.C:- O(V)
-------------------
   class Solution {
    int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
 int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int p1 = find(parent, s1.charAt(i) - 'a');
            int p2 = find(parent, s2.charAt(i) - 'a');
            parent[p1] = Math.min(p1, p2);
            parent[p2] = Math.min(p1, p2);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + find(parent, c - 'a')));
        }
        return sb.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}       
