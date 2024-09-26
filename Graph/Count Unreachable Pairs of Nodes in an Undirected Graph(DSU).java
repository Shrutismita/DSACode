Q:- https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================================
  class Solution {
    int[] parent ;
    int[] rank;
    //1.DSU code
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
                return ;
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
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n;i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        //Step-2.process the edges so that we can make the components
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            Union(u,v);
        }
        //Step-3. Create array for storing  parent(component)-->size of component
        int[] sizeOfComp = new int[n];
        for(int i = 0; i < n; i++)
        {
            int parent = find(i);//parent--> reprentative
            sizeOfComp[parent]++;
        }
        //Step-4. find result from sizeOfComp
        long result = 0;
        long remainingNodes = n;
        for(int size : sizeOfComp)
        { 
            if (size == 0) {
                continue;
            }
            remainingNodes -= size;
            result += size * remainingNodes;
        }
      return result;
    }
}
