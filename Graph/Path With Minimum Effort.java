Q:- https://leetcode.com/problems/path-with-minimum-effort/
T.C:- O(ElogV)
S.C:- O(V+E)
===========================================================================================
  //Approach-1 : Using Dijkstra's Algo
  class Pair
{
    int distance;
    int x;
    int y;
    Pair(int distance,int x,int y)
    {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
         int m = heights[0].length;
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1, 0}};

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[][] result = new int[n][m];
        for(int i = 0;i < n;i++)
               Arrays.fill(result[i],Integer.MAX_VALUE);

        result[0][0] = 0;
        pq.add(new Pair(0,0,0)) ;

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.distance;

            for(int[] dir : dirs)
            {
                int nr = x+dir[0];
                int nc = y+dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m)
                {
                    int newDist = Math.max(dist,Math.abs(heights[x][y] - heights[nr][nc]));
                    if(result[nr][nc] > newDist)
                    {
                        result[nr][nc]=newDist;
                        pq.add(new Pair(result[nr][nc],nr,nc));
                    }
                }
            }
        }    
        return result[n-1][m-1];
    }
}
