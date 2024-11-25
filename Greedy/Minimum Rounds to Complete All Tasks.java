Q:- https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
************************************************************************************
  class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int task : tasks)
            mp.put(task, mp.getOrDefault(task,0) +1);

          int round = 0;
          for(Map.Entry<Integer,Integer> curr : mp.entrySet())
          {
             int count = curr.getValue();
              if(count == 1) 
                   return -1;
               if(count%3 == 0)    
                     round += count/3;
                else
                  round += count/3+1;  
          }   
          return round;
    }
}
