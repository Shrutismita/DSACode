Q:- https://leetcode.com/problems/find-all-people-with-secret/
*******************************************************************************************************************
//Approach-1 (Using BFS Graph Traversal)
//T.C : O(M * (M+N)) -> M = Number of meetings, N = number of people, there can be at most N+M elements in the queue and a person may have M neighbours
//S.C : O(M+N)

  ----------------------------------------------------------------------------------------------------------------------
  class Solution {
   
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] meeting : meetings)
        {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            adj.get(person1).add(new int[]{person2,time});
            adj.get(person2).add(new int[]{person1,time});
        }
        int[] earlySecretTime = new int[n];
         Arrays.fill(earlySecretTime,Integer.MAX_VALUE);
       Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        que.add(new int[]{firstPerson,0});
         
         earlySecretTime[0] = 0;
         earlySecretTime[firstPerson] = 0;

         while(!que.isEmpty())
         {
            int[] current = que.poll();
            int person = current[0];
            int time = current[1];

            for(int[] ngbr : adj.get(person))
            {
                 int nextPerson = ngbr[0];
                 int timeNext = ngbr[1];
                 if(timeNext >= time && earlySecretTime[nextPerson] > timeNext)
                 {
                    earlySecretTime[nextPerson] = timeNext;
                    que.add(new int[]{nextPerson,timeNext});
                 }
            }
         }
           List<Integer> result = new ArrayList<>();
           for(int i = 0 ; i<n; i++)
           {
                 if(earlySecretTime[i] != Integer.MAX_VALUE)
                       result.add(i);
           }
        return result;   
    }
}
 **********************************************************************************************************************
//Approach-2 (Using DFS Graph Traversal)
//T.C : O(M * (M+N)) -> M = Number of meetings, N = number of people (Although it's a DFS, but we also revisit some nodes again with better secret knowing time)
//S.C : O(M+N)
-----------------------------------------------------------------------------------------------------------------
   class Solution {
   
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] meeting : meetings)
        {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            adj.get(person1).add(new int[]{person2,time});
            adj.get(person2).add(new int[]{person1,time});
        }
        int[] earlySecretTime = new int[n];
         Arrays.fill(earlySecretTime,Integer.MAX_VALUE);        
         earlySecretTime[0] = 0;
         earlySecretTime[firstPerson] = 0;

          dfs(0, 0, adj, earlySecretTime);
          dfs(firstPerson, 0, adj, earlySecretTime);

           List<Integer> result = new ArrayList<>();
           for(int i = 0 ; i<n; i++)
           {
                 if(earlySecretTime[i] != Integer.MAX_VALUE)
                       result.add(i);
           }
        return result;   
    }
       private void dfs(int person, int time, List<List<int[]>> adj, int[] earlySecretTime) 
       {
                  for(int[] ngbr : adj.get(person))
            {
                 int nextPerson = ngbr[0];
                 int timeNext = ngbr[1];
                 if(timeNext >= time && earlySecretTime[nextPerson] > timeNext)
                 {
                    earlySecretTime[nextPerson] = timeNext;
                     dfs(nextPerson, timeNext, adj, earlySecretTime);
                 }
            }
       }
}
