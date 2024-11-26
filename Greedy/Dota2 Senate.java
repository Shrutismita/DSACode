Q:- https://leetcode.com/problems/dota2-senate/
 Company Tags                : Meta
***************************************************************************************************************
  //Approach-1 (Using 2 Queues)
  //T.C:- O(n)
  --------------------------------------
  class Solution {
    public String predictPartyVictory(String senate) {
          int n = senate.length();
          Deque<Integer> radiantQueue = new ArrayDeque<Integer>();
             Queue<Integer> direQueue = new LinkedList<>();
        // Initialize queues with senator indices based on their party
        for (int i = 0; i < n; i++) 
        {
            char party = senate.charAt(i);
            if (party == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

         while (!radiantQueue.isEmpty() && !direQueue.isEmpty())
         {
            int radiantIndex = radiantQueue.poll(); // Get the index of the next Radiant senator
            int direIndex = direQueue.poll();       // Get the index of the next Dire senator

            // Compare the indices to determine which senator gets banned
            if (radiantIndex < direIndex) {
                radiantQueue.add(radiantIndex + n); // Add Radiant senator back to the queue for the next round
            } else {
                direQueue.add(direIndex + n);       // Add Dire senator back to the queue for the next round
            }
         }
         // Return the result based on which party's queue is non-empty
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
=======================================================================================================
//Approach-2 (Using Single Queue)
//T.C:- O(n)
---------------------------------------------------
  class Solution {
    public String predictPartyVictory(String senate) {
         var queue = new ArrayDeque<Character>();

   for (var c : senate.toCharArray())
     queue.add(c);

   char c = 'R';
   while (!queue.isEmpty()) {
     c = queue.poll();
     queue.add(c);

     if (c == 'R' && !queue.remove('D'))
       return "Radiant";
     if (c == 'D' && !queue.remove('R'))
       return "Dire";
   }
   return null;
 }
}
  
