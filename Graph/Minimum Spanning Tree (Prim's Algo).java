Q:- https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
Minimum Spanning Tree
Given a weighted, undirected, and connected graph with V vertices and E edges, 
  your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. 
  The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers. Each vector represents an edge, 
  with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.
  ===========================================================================================================================
  T.C:- O(ElogV)
  S.C:- O(V^2)
===================================================================================================================
class Pair
{
    int weight;
    int node;
    Pair(int weight,int node)
    {
        this.weight = weight;
        this.node = node;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int sum = 0;
        
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int wt = curr.weight;
            int node = curr.node;
            
            if(visited[node] == true) continue;
            
            visited[node] = true;
            sum += wt;
            
            for(int[] temp : adj.get(node))
            {
                int neighbor = temp[0];
                int neighbor_wt = temp[1];
                 
                 if(visited[neighbor] == false)
                 {
                     pq.add(new Pair(neighbor_wt, neighbor));
                 }
            }
        }
        return sum;
    }
}
