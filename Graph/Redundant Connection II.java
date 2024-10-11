Q:- https://leetcode.com/problems/redundant-connection-ii/
************************************************************************************
//Using DSU
//T.C : O(n) (find and union operation takes O(4) time in worst case)
//S.C : O(n)
-------------------------------------------------------
  class Solution {
 int parent[];
    int rank[];

    // Initialize the Union-Find data structure
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        // Path compression: directly connect x to its root parent
        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public boolean union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);

        // If they share the same parent, a cycle is detected
        if(parent_x == parent_y){
            return false;
        } else if (rank[parent_x] > rank[parent_y]) {
            // Attach the shorter tree to the root of the taller tree
            parent[parent_y] = parent_x;
        } else if (rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        } else {
            // If both trees have the same height, choose one as the root and increase its rank
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int direct_parent[] = new int[n];
        Arrays.fill(direct_parent, -1);

        int candidate1[] = null; // First conflicting edge
        int candidate2[] = null; // Second conflicting edge

        // Step 1: Detect if there's a node with two parents
        for(int i = 0; i < n; i++){
            int src = edges[i][0] - 1;
            int dest = edges[i][1] - 1;

            if(direct_parent[dest] != -1){ // If a node already has a parent
                candidate1 = new int[]{direct_parent[dest] + 1, dest + 1}; // First parent edge
                candidate2 = new int[]{src + 1, dest + 1}; // Current edge, second parent
            } else {
                direct_parent[dest] = src; // Record the parent
            }
        }

        // Step 2: Use Union-Find to detect cycles
        init(n); 
        for(int i = 0; i < n; i++){
            if(candidate2 != null && Arrays.equals(edges[i], candidate2)) {
                // Temporarily ignore the second parent edge to check for a cycle
                continue;
            }

            int src = edges[i][0] - 1;
            int dest = edges[i][1] - 1;

            if(!union(src, dest)){ //Cycle is detected
                if(candidate1 == null){ 
                    return edges[i];  //CYCLE ONLY
                } else {
                    return candidate1; //TWO PARENT + CYCLE
                }
            }
        }

        return candidate2; //ONLY TWO PARENT ISSUE
    }
}

  
