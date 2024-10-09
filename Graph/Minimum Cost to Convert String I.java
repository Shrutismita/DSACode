Q:- https://leetcode.com/problems/minimum-cost-to-convert-string-i/
**********************************************************************************
  //Approach-1 (Using Simple Floyd Warshall Algorithm)
//T.C : O(n)  -> Because other for loops run only for constant time 26*26*26
//S.C : O(1) -> We take distances matrix of 26*26 which is constant
  ===============================================================================================
  class Solution {
    private void FloydWarshall(long[][] distances, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < original.length; ++i) {
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            distances[s][t] = Math.min(distances[s][t], (long) cost[i]);
        }

        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distances = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        FloydWarshall(distances, original, changed, cost);//update distances(adjMatrics) with shortest path using Floyd Warshall

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            if (distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return ans;
    }
}
============================================================================================================
  //Approach-2 (Using Simple Dijkstra's Algorithm)
//T.C : n * (time complexity of Dijkstra) = O(n * (V+E)logV) , where V = number of vertices and E = number of edges
//S.C : O(V+E) -> We create a graph, where V = number of vertices and E = number of edges
  =============================================================================================
  class Solution {
    class Pair{
        int distance;
        char node;
        Pair(int distance, char node)
        {
            this.distance = distance;
            this .node = node;
        }
    }
    private void dijkstra(Map<Character, ArrayList<Pair>> adj, char source,long[][] distances) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.add(new Pair(0, source));

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int d = curr.distance;
            char node = curr.node;

            for(Pair child : adj.getOrDefault(node,new ArrayList<>()))
            {
                int dist = child.distance;
                char adjNode = child.node;
                if(distances[source - 'a'][adjNode - 'a'] > dist+d)
                {
                    distances[source - 'a'][adjNode - 'a']  = dist+d;
                    pq.add(new Pair(d+dist,adjNode));
                }
            }
        }
    }   

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distances = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        Map<Character,ArrayList<Pair>> adj = new HashMap<>();
        for(int i = 0; i< original.length;i++)
        {
            adj.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Pair(cost[i], changed[i]));
        }
        // Populate distances using Dijkstra's
        for (char it : original) {
            dijkstra(adj, it, distances);
        }


        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            if (distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return ans;
    }
}
  
