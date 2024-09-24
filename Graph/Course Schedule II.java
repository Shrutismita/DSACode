Q:- https://leetcode.com/problems/course-schedule-ii/
T.C:- O(V+E)
S.C:- O(V)
=================================================================================
  ////Approach-1 (Using BFS Topological Sort Concept)
  class Solution {
    int[] topologicalSortCheck(List<List<Integer>> adj,int n,int[] indegree)
    {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n];
        int count = 0;
         int k = 0;
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                count++;
                result[k++] = i;
                queue.add(i);
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
                    result[k++] = v;
                    queue.add(v);
                }
            }
        }
        if(count == n)
           return result;

        //Means we had a Cycle and we could not complete all courses   
        return new int[0];   
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites)
        {
            int a = prerequisite[0];
            int b = prerequisite[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        return topologicalSortCheck(adj,numCourses,indegree);
    }
}
======================================================================================================================================
