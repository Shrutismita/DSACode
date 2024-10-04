Q:- https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

T.C:- O(V+E)
S.C:- O(V)
==============================================================================================
  class Solution {
    int longestPath = 1; // path is atleast going to be 1 unit long (a node itself)
    int dfs(List<List<Integer>> adj, int curr_Node, int parent, String s)
    {
        // there can be multiple children paths
        // but only the longest two of them can combine along with the current node to form a single longest path
        // so we take two variables which will store the longest and second longest path lengths
         int longest = 0;
         int second_longest = 0;
        for(int child : adj.get(curr_Node))
        {
            if(child == parent) continue;
            
             // Now we call the dfs for our child node
            // child becomes the current node, current node becomes the parent of the child
            int child_longest_length = dfs(adj, child, curr_Node, s);

             if(s.charAt(child) == s.charAt(curr_Node)) continue;

             if(child_longest_length > longest)
             {
                   second_longest = longest;
                   longest = child_longest_length;
             }
             else if( child_longest_length > second_longest)
                      second_longest = child_longest_length;

        }

         // as previously discussed, two longest lengths under a node will combine along with the node itself
        // to form a subtree like path (a subtree with two branches/paths)
        // so maxLen + secondMaxLen + 1 (the current node itself)
         longestPath = Math.max(longestPath, longest + second_longest + 1);
         
        // we return the max length of path + 1 (the current node itself) for utilisation upon backtracking
        // this max length is length of the path we are in right now
          return longest + 1;
    }
    public int longestPath(int[] parent, String s) {
         int n = parent.length;
         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++)
               adj.add(new ArrayList<>());

          for(int i = 1; i < n;i++)
          {
              int u = i;
              int v = parent[i];
              adj.get(u).add(v);
              adj.get(v).add(u); 
           }   

           dfs(adj,0,-1,s); // calling the dfs

        return  longestPath;     // returning the longest path length found    
    }
}
