Q:- https://leetcode.com/problems/shortest-path-in-binary-matrix/

========================================================================================================================
//Approach-1 (Using BFS - Works because all edges are of weight = 1)  
Time complexity: O(n^2)
Space complexity: O(n^2) 
 ==============================================================================================
  class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
                 return -1;

        int[][] directions  ={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        int pathLength = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();

            while(size-- > 0)
            {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                 
                 if(row == n-1 && col == n-1)
                     return pathLength;

                 for(int[] dir : directions)
                 {
                    int newRow = row +dir[0];
                    int newCol = col+dir[1];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0)
                    {
                        grid[newRow][newCol] = 1;
                        queue.add(new int[]{newRow,newCol});
                    }
                 }    
            }
            pathLength++;
        }
       return -1;
    }
}

=====================================================================================================================
  //Approach-2 (Using Dijkstra's Algorithm) - Using Priority_queue (min-heap)
T.C:- O(ElogV)
S.C:- O(V+E)
=========================================================================================
  class Pair
{
    int distance;
    int x;
    int y;
    Pair(int distance, int x, int y)
    {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][]  directions = {{1,1}, {0,1},{1,0},{0,-1},{-1,0},{-1, -1},{1, -1},{-1, 1}};
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
                 return -1; //base case where no way to go from src -> dest

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);

        int[][] result = new int[n][n];
        for(int i =0; i < n;i++)
            Arrays.fill(result[i],Integer.MAX_VALUE);

        result[0][0] = 0;
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.distance;
             for(int[] dir :directions)
             {
                int nr = x+dir[0];
                int nc = y+dir[1];

                if(nc >= 0 && nc<n && nr >= 0 && nr < n && grid[nr][nc] == 0)
                {
                    if(dist + 1 < result[nr][nc])
                    {
                        result[nr][nc] = dist +1;
                        pq.add(new Pair(result[nr][nc],nr,nc));
                    }
                }
             }
        }
         if(result[n-1][n-1] == Integer.MAX_VALUE)
                 return-1;

        return result[n-1][n-1]+1;             
    }

}
  
  
