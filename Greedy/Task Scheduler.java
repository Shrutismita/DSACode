Q:- https://leetcode.com/problems/task-scheduler/
  Company Tags  : Meta
***********************************************************************************************************************************
//Time complexity: O(n), where n is the number of tasks. The frequency counting and maximum frequency finding take linear time.
//Space complexity: O(1), as the array used for frequency counting has a fixed size (26 for uppercase letters).
-------------------------------------------------------------------------------------------------------------------------
  class Solution {
    public int leastInterval(char[] tasks, int n) {
         int m = tasks.length;
         if(n == 0)
             return m;

         int[] freqCounter = new int[26];
         for(char task : tasks)
         {
            freqCounter[task - 'A']++;
         }    

         Arrays.sort(freqCounter);

         int chunks      = freqCounter[25]-1;
         int idolSpots   = chunks*n;
        
        for(int i = 24; i>=0 ; i--) {
            idolSpots -= Math.min(chunks, freqCounter[i]);
        }
        
        if(idolSpots > 0)
            return m + idolSpots;
        
        return m;
    }
}
