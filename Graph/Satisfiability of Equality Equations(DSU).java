Q:- https://leetcode.com/problems/satisfiability-of-equality-equations/
T.C:- O(V+E)
S.C:- O(V)
===============================================================================================
  class Solution {
    int[] parent;
        int[] rank;

        int find(int x)
        {
            if(parent[x] == x)
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
            {
                parent[y_parent] = x_parent;
            }  
            else if(rank[x_parent] < rank[y_parent])
            {
                parent[x_parent] = y_parent;
            }
            else
            {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i = 0; i< 26;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        /*First perform all the merging Equal = operation*/
        for(String s : equations )
        {
            if(s.charAt(1) == '=')
            {
                  Union(s.charAt(0) - 'a',s.charAt(3) - 'a');
            }
        }
         /*Now traverse on the whole string and search for any != operation and check if there parents are same*/
        for(String s : equations )
        {
            if(s.charAt(1)== '!')
            {
                  if(find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a'))
                      return false;
            }
        }
        return true;
    }
}
