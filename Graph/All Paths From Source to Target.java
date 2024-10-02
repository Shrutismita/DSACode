Q:- https://leetcode.com/problems/all-paths-from-source-to-target/
T.C:- O(V+E)
S.C:- O(V+E)
=====================================================================================
//Approach - 1 (More like a Graph DFS)
  -------------------------------------
  class Solution {
     int target;
     List<List<Integer>> result = new ArrayList<>();
     void dfs(int[][] graph,int start,List<Integer> path)
     {
        path.add(start);
        if(start == target) {
            result.add(path);
            return;
        }
        else
        {
           for(int x : graph[start]) 
           {           
              dfs(graph, x,new ArrayList<>(path));           
            }
        }
        
     }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
         target = graph.length -1;
         

             dfs(graph, 0, new ArrayList<>());
        
        return result;   
         
    }
}
===============================================================================================
  //Approach-2 (Using BFS)
  class Solution {
     
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
         List<List<Integer>> result = new ArrayList<>();
         Queue<List<Integer>> que = new LinkedList<>();
         int target = graph.length -1;

         que.add(new ArrayList<>(Arrays.asList(0)));

         while(!que.isEmpty())
         {
            List<Integer> path = que.poll();
            int lastNode = path.get(path.size() -1);
            if(lastNode == target)
            {
                result.add(path);
            }
            else
            {
                for(int v : graph[lastNode])
                {
                     List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(v);
                    que.add(newPath);
                }
            }
         }      
        return result;   
         
    }
}
  
