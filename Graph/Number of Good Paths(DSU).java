Q:- https://leetcode.com/problems/number-of-good-paths/
T.C:- O(V+E logE)
S.C:- O(V)
=================================================================================
  class Solution {
   int[] parent, count;
    int result;
    int find(int x)
    {
        if(parent[x] == x)
           return x;

        return parent[x] = find(parent[x]);
    }
    void Union (int x,int y,int[] vals)
    {
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent)
             return ;
        //If two adjacent node have same value, they will increase the number of good paths corresponding to the number of nodes in their component 
        if(vals[x_parent] == vals[y_parent]) {
            result += count[x_parent]*count[y_parent];
            count[x_parent] += count[y_parent];
            parent[y_parent] = x_parent;
        } 
        
        // If two nodes have different values, join the smaller one to the larger one
        else if(vals[x_parent] > vals[y_parent]) {
            parent[y_parent] = x_parent;
        } else {
            parent[x_parent] = y_parent;
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
         // Sorting the edges in increasing order of the corresponding nodes
        Arrays.sort(edges, (o1, o2) -> Integer.compare(Math.max(vals[o1[0]], vals[o1[1]]), Math.max(vals[o2[0]], vals[o2[1]])));
        
       // Parent array for union
        parent = new int[n];
        
        // Count array to keep track of number of nodes equal to a given node
        count = new int[n];
        // Initially each node will have just itself in the union component
        Arrays.fill(count, 1);
        // Minimum number of good paths is equal to the number of nodes
        result = n;
        for(int i = 0; i < n;i++)        
            parent[i] = i;
            
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

             Union(u, v, vals);
        }
      return result;
    }
}
