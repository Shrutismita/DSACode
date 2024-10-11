Q:- https://leetcode.com/problems/redundant-connection/
****************************************************************************
//Using DSU
//T.C : O(n) 
//S.C : O(n)
----------------------------------------------------  
  class Solution {
    public int[] findRedundantConnection(int[][] edges) {
     int n = edges.length;
        int[] parent = new int[n+1];
        
        Arrays.fill(parent,-1);
        
        for(int[] e : edges){
            int p1 = find(e[0],parent);
            int p2 = find(e[1],parent);
            if(p1 != p2)
                union(p1,p2,parent);
            else
                return new int[]{e[0],e[1]};
        }
        
        return new int[]{};
    }
    
    private int find(int vertex,int[] parent){
        while(parent[vertex] > -1)
            vertex = parent[vertex];
        
        return vertex;
    }
    
    private void union(int p1,int p2,int[] parent){
        int totalNodes = parent[p2] + parent[p1];
        if(parent[p1] <= parent[p2]){
            parent[p2] = p1;
            parent[p1] = totalNodes;
        }else{
            parent[p1] = p2;
            parent[p2] = totalNodes;
        }
    }
}
