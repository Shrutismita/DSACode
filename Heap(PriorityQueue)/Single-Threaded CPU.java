Q:- https://leetcode.com/problems/single-threaded-cpu/
 Company Tags                : Google
 *************************************************************************************************
  //TC : O(nlogn)
  -------------------------------
  class Solution {
     class Task {
        int processing_time, index;
        Task(int processing_time, int index) 
        {          
            this.processing_time = processing_time;
            this.index = index;
        }
     }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            //  sortedTasks[i][0] = tasks[i][0];
            //  sortedTasks[i][1] = tasks[i][1];
            //  sortedTasks[i][2] = i;
             int start_time = tasks[i][0];
             int processing_time = tasks[i][1];
             sortedTasks[i] = new int[]{start_time, processing_time, i};
             
        }
        //sort
        Arrays.sort(sortedTasks,(a,b)->(a[0] == b[0]) ? a[1] - b[1]:a[0]-b[0]);

        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->
         (a.processing_time == b.processing_time) ? a.index-b.index :a.processing_time -b.processing_time);
        int[] result = new int[n];
         int j = 0;
        int curr_time = 0;
        int idx = 0;
        while(idx < n || !pq.isEmpty())
        {
           
            while(idx < n && sortedTasks[idx][0] <= curr_time)
            {
                pq.add(new Task(sortedTasks[idx][1], sortedTasks[idx][2])); //log(n)
                idx++;
            }
             if(pq.isEmpty() && curr_time < sortedTasks[idx][0])
            {
                curr_time = sortedTasks[idx][0];
                continue;
            }       
            
            Task curr_task = pq.poll();
            curr_time += curr_task.processing_time;
            result[j++]=curr_task.index;
            
            
        }
        return result;

    }
}
