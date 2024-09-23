Q:- https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
  Detect cycle in a directed graph (BFS)
  Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
  ===============================================================================================================
  T.C:- O(V+E)
S.C:- O(V)
=================================Using BFS================================================
  class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[V];
        //1
        for(int u = 0; u < V ; u++)
        {
            for(int v :adj.get(u))
            {
                indegree[v]++;
            }
           
        }
        int count = 0;
        //2.fill queue
        for(int i = 0; i <V;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
                count++;
            }
        }
        //3.Simple BFS
        while(!queue.isEmpty())
        {
            int u = queue.poll();
            for(int v : adj.get(u))
            {
                indegree[v]--;
                if(indegree[v] == 0)
                {
                    queue.add(v);
                    count++;
                }
            }
            
        }
        
        if(count == V) //we visited all nodes means no cycle
        {
            return false;
        }
       
            return true;
       
    }
}
