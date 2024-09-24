Q:- https://leetcode.com/problems/course-schedule/
T.C:- O(V+E)
S.C:- O(V)
=============================================================================================
  //Approach-1 (Using BFS Cycle Check - Kahn's Algorithm (Topological Sort)

  class Solution {
    boolean topologicalSortCheck(List<List<Integer>> adj,int numCourses,int[] indegree)
    {
       Queue<Integer> queue = new LinkedList<>();
       int count = 0;
       for(int i = 0; i < numCourses;i++)
       {
             if(indegree[i] == 0)
             {
                queue.add(i);
                count++;
             }
       }
       while(!queue.isEmpty())
       {
           int u = queue.poll();
           for(int v : adj.get(u))
           {
              indegree[v]--;
               if(indegree[v] == 0)
               {
                  count++;
                  queue.add(v);
               }
           }
       }
       if(count == numCourses) //I was able to visit all nodes (course)
              return true; //i.e. I was able to finish all courses

       return false; //means there was a cycle and I couldn't complete all courses      
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        
        int[] indegree = new int[numCourses];////kahn's algo

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites)
        {
            int a = prerequisite[0];
            int b = prerequisite[1];

             //b ---> a
             adj.get(b).add(a);
             //arrow is going to 'a' from 'b'
             indegree[a]++;
        }
        

         //if cycle is present, not possible        
        return topologicalSortCheck(adj, numCourses, indegree);
    }
}
===========================================================================================================
  //Approach-2 (Using DFS Cycle Check)
  class Solution {
    boolean isCycleDFS( List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion)
    {
        visited[u]=true;
        inRecursion[u]=true;
        for(int v : adj.get(u))
        {
            if(visited[v] == false && isCycleDFS(adj,v,visited,inRecursion))            
                   return true;            
             else if(inRecursion[v] == true)
                return true;
        }
        inRecursion[u] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites)
        {
            int a = prerequisite[0];
            int b = prerequisite[1];

             //b ---> a
             adj.get(b).add(a);
             
        }
         boolean[] visited = new boolean[numCourses];
         boolean[] inRecursion = new boolean[numCourses];

         for(int i = 0; i < numCourses; i++)
         {
            if(visited[i] == false && isCycleDFS(adj,i,visited,inRecursion))
            {
                return false;
            }
         }
     return true;       
    }
}
