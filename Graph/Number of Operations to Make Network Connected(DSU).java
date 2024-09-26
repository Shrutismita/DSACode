Q:- https://leetcode.com/problems/number-of-operations-to-make-network-connected/

T.C:- O(V+E)
S.C:- O(V)
=========================================================================================================
  class Solution {
    int[] parent;
    int[] rank;
    int find(int x)
    {
        if(parent[x] == x)
                return x;

        return parent[x] = find(parent[x]);        
    }
    void Union(int x , int y)
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
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n - 1)
                return -1;

        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        } 
        int component = n;
        for(int[] connection :connections )
        {
            if(find(connection[0]) != find(connection[1]))
            {
                component--;
                Union(connection[0],connection[1]);
            }
        }    

        return  component - 1;
    }
}
