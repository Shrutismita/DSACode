Q:- https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
=====================================================================================
class Pair  implements Comparable<Pair>
{
    int weight;
    int u;
    int v;
    Pair(int weight,int u,int v)
    {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
     public int compareTo(Pair p){
        return this.weight-p.weight;
    }
}
class Solution {
     public  int[] parent;
      public int[] rank;
      int find(int x)
     {
         if(parent[x] == x)
                 return x;

            return parent[x] = find(parent[x]);  
     }
     void Union(int x,int y)
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
      int Kruskal(List<Pair> edges)  
      {
          int sum =  0;
          for(Pair temp : edges)
          {
              int u = temp.u;
              int v = temp.v;
              int wt = temp.weight;
              
              int parent_u = find(u);
              int parent_v = find(v);
              
              if(parent_u != parent_v)
              {
                  Union(parent_u,parent_v);
                  sum  += wt;
              }
          }
          return sum;
      }
    int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
            parent = new int[V];
            rank = new int[V];
        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
       
          //sort all the edges according to weights
        //List<int[]> edges = new ArrayList<>();
         List<Pair> edges=new ArrayList<>();
         
        for(int i = 0; i <adj.size() ;i++)
        {
            List<int[]> node=adj.get(i);
            for(int[] edge:node)
            {
                int u = i;
                int v = edge[0];
                int wt = edge[1];
                edges.add(new Pair(wt,i,v));
            }
        }
        
         Collections.sort(edges);
         return Kruskal(edges);
       
    }
}
