Q:- https://leetcode.com/problems/reconstruct-itinerary/
T.C : O(V^2)
S.C: O(V)
======================================================================================
  Approach-1 (Using Eulerian Path and Circuit)
  -------------------------------------------------
  class Solution {
      Map<String, PriorityQueue<String>> graph = new HashMap<>();
      public List<String> findItinerary(List<List<String>> tickets) {
        
        if (tickets == null || tickets.isEmpty())
           return Collections.EMPTY_LIST;
           
        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            if (!graph.containsKey(source))
                graph.put(source, new PriorityQueue<>());

            graph.get(source).add(destination);

        }
                 
          List<String> itinerary = new ArrayList<>(graph.size());
         dfs("JFK",itinerary);
         Collections.reverse(itinerary);
        return itinerary;
    }
    void dfs(String source,List<String> itinerary)
    {
        /**
        * if now more destination possible from this source, then we are at the bottom most.
        */
       if (graph.get(source) == null || graph.get(source).isEmpty()) {
           itinerary.add(source);
           return;
       }


       /**
        * Try all the destination from this source incrementally.
        * This is important for input like [[JFK, KUL], [JFK, NRT], [NRT, JFK]]
        * because once you reach Kul, you can't go anywhere but we have tickets left, so we should go NTR first
        */
       while (!graph.get(source).isEmpty()) {
           String nextDestination = graph.get(source).poll();
           dfs(nextDestination,itinerary);
       }
       /**
        * We are at the bottom, traverse back
        */
       itinerary.add(source);

   }
}
