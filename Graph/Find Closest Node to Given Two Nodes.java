Q:- https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
T.C:- O(2n)
S.C:- O(n)
=================================================================================
  //Approach-1 (DFS)
  ------------------------
  class Solution {
    int n ;
    void dfs(int[] edges, int startNode,int[] dist_node, boolean[] visited)
    {
          visited[startNode] = true;
          int v = edges[startNode];
          if(v != -1 && visited[v] == false)
          {
            visited[v] =true;
             dist_node[v] = 1 + dist_node[startNode];
            dfs(edges, v, dist_node, visited);
          }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        int[] dist_1 = new int[n];
        Arrays.fill(dist_1,Integer.MAX_VALUE);
         int[] dist_2 = new int[n];
        Arrays.fill(dist_2,Integer.MAX_VALUE);
        boolean[] visited_1 = new boolean[n];
        boolean[] visited_2 = new boolean[n];

         dist_1[node1] = 0;
         dist_2[node2] = 0;
        dfs(edges, node1, dist_1, visited_1);
        dfs(edges, node2, dist_2, visited_2);
          
           int minDistNode = -1;
           int minDistTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            
            int maxD = Math.max(dist_1[i], dist_2[i]);
            
            if (minDistTillNow > maxD) {
                minDistNode = i;
                minDistTillNow = maxD;
            }
        }

        return minDistNode;
        
    }
}
======================================================================================
  //Approach-2 (BFS)
  -------------------
  class Solution {
    int n ;
    void bfs(int[] edges, int startNode,int[] dist_node)
    {
         Queue<Integer> que = new LinkedList<>();
         que.add(startNode);
          dist_node[startNode] = 0;
        boolean[] visited = new boolean[n];
        visited[startNode] = true;
        
        while(!que.isEmpty()) {
            int u = que.poll();
           
            int v = edges[u];
          
          if(v != -1 && visited[v] == false)
          {
            visited[v] =true;
             dist_node[v] = 1 + dist_node[u];
            que.add(v);
          }
    }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        int[] dist_1 = new int[n];
        Arrays.fill(dist_1,Integer.MAX_VALUE);
         int[] dist_2 = new int[n];
        Arrays.fill(dist_2,Integer.MAX_VALUE);
                 
         bfs(edges, node1, dist_1);
        bfs(edges, node2, dist_2);
                  
           int minDistNode = -1;
           int minDistTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            
            int maxD = Math.max(dist_1[i], dist_2[i]);
            
            if (minDistTillNow > maxD) {
                minDistNode = i;
                minDistTillNow = maxD;
            }
        }

        return minDistNode;
        
    }
}
