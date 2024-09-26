Q:- https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 Note: The Graph doesn't contain any negative weight cycle.
The structure of adjacency list is as follows :-
For Example : adj = {  {{1, 1}, {2, 6}}  , {{2, 3}, {0, 1}}  , {{1, 3}, {0, 6}}  }
Here adj[i] contains a list which contains all the nodes which are connected to the ith vertex. Here adj[0] = {{1, 1}, {2, 6}} means there are two nodes conneced to the 0th node, node 1 with an edge weight of 1 and node 2 with an edge weight of 6 and similarly for other vertices.
=======================================================================================================================================
T.C:-  O(E * log(V))
S.C:- O(V)
=========================================================================================
  Approach - 2 Using Set
  class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        // Result array to store the shortest distance from source S
        int[] result = new int[V];
        Arrays.fill(result,Integer.MAX_VALUE);// Initially, all distances are infinity

        // TreeSet to store pairs of [distance, vertex], where distance is the current known shortest distance
        TreeSet<int[]> set = new TreeSet<>((a,b) -> {
            if(a[0] == b[0])
            {
                return a[1] - b[1]; // If distances are equal, sort by vertex
            }
            else
            {
                return a[0] - b[0]; // Sort by distance (smallest distance first)
            }
        });
        
        
          // Start from the source node (distance 0 to itself)
          result[S] = 0;
           set.add(new int[]{0,S});// Add source with distance 0
           
           while(!set.isEmpty())
           {
               // Get the node with the smallest known distance
               int[] curr = set.pollFirst(); // Retrieves and removes the first (smallest) element
               int currDist = curr[0]; // Current distance
               int node = curr[1];   // Current vertex
               
                // Iterate through all neighbors of the current vertex
               for(ArrayList<Integer> neighbor : adj.get(node))
               {
                   int adjNode = neighbor.get(0);  // Neighbor vertex
                   int dist = neighbor.get(1);  // Weight of the edge between node and adjNode
                    // If a shorter path to adjNode is found
                   if(currDist + dist < result[adjNode])
                   {
                        // If this node is already in the set, remove it before updating
                       if(result[adjNode] != Integer.MAX_VALUE)
                       {
                           set.remove(new int[]{result[adjNode],adjNode});
                       }
                       
                        // Update the shortest distance
                       result[adjNode] = currDist + dist;
                       
                         // Add the updated distance to the TreeSet
                       set.add(new int[]{result[adjNode],adjNode});
                       
                   }
               }
           }
          return result;
    }
}

