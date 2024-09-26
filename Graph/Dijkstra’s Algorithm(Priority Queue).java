Q:- : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
The structure of adjacency list is as follows :-
For Example : adj = {  {{1, 1}, {2, 6}}  , {{2, 3}, {0, 1}}  , {{1, 3}, {0, 6}
Here adj[i] contains a list which contains all the nodes which are connected to the ith vertex. Here adj[0] = {{1, 1}, {2, 6}} means there are two nodes conneced to the 0th node, node 1 with an edge weight of 1 and node 2 with an edge weight of 6 and similarly for other vertices.
=====================================================================================================================================
T.C:- O(E * log(V))
S.C:- O(V)
==============================================================================================
  Approach -1 Using Priority Queue
  
class Pair
{
    int distance;
    int node;
    Pair(int distance, int node)
    {
        this.distance = distance;
        this.node = node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] result = new int[V];
        for(int i = 0; i < V; i++)
          result[i] = Integer.MAX_VALUE;
          
          result[S] = 0;
          pq.add(new Pair(0,S));
          while(!pq.isEmpty())
          {
              Pair p = pq.poll();
              int d = p.distance;
              int node = p.node;
               for(int x=0;x<adj.get(node).size();x++)
               {
                   int adjNode = adj.get(node).get(x).get(0);
                   int dist = adj.get(node).get(x).get(1);
                   
                   if(dist+d < result[adjNode] )
                   {
                       result[adjNode] = dist + d;
                       pq.add(new Pair(result[adjNode],adjNode));
                   }
               }
          }
          return result;
    }
}

