Q:- https://leetcode.com/problems/clone-graph/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  Approach - 1(Using BFS)
  ---------------------------
  
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        //hashmap to keep track of all cloned nodes
        Map<Node,Node> map = new HashMap<>();

         //queue to perform a bfs
           Queue<Node> queue = new LinkedList<>();

           queue.add(node);
           map.put(node,new Node(node.val));

           while(!queue.isEmpty())
           {
               Node curr_node = queue.poll();
               Node currClone = map.get(curr_node);

               for(Node neighbor : curr_node.neighbors)
               {
                  if(!map.containsKey(neighbor))
                  {
                        //clone the neighbor node and add it to map
                          map.put(neighbor,new Node(neighbor.val));
                          queue.add(neighbor);
                  }
                  currClone.neighbors.add(map.get(neighbor));
               }
           }
           return map.get(node);
    }
}
=================================================================================================
  Approach - 2(Using DFS)
  ----------------------------
  
class Solution {
    //hashmap to keep track of all cloned nodes
        Map<Node,Node> map = new HashMap<>();
        Node dfs(Node curr_node)
        {
             if(curr_node == null) return null;

             if(map.containsKey(curr_node)) 
                     return map.get(curr_node);

              map.put(curr_node,new Node(curr_node.val));
              for(Node adj : curr_node.neighbors)    
              {
                map.get(curr_node).neighbors.add(dfs(adj));
              }   
              return map.get(curr_node);
        }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
         
         return dfs(node);          
    }
}
