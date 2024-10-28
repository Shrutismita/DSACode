Q:- https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
************************************************************************************************
//Using Dijkstra Algo 
//Time complexity: O(n*log(n))
//Space complexity: O(n)
-------------------------------------------------
  class Solution {
    class Pair
    {
        int row;
        int col;
        int cost;
        Pair(int row,int col, int cost)
        {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
         int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);

        pq.add(new Pair(0,0,0));

        int[][] vis = new int[m][n];
        for(int[] it : vis)
        {
            Arrays.fill(it, Integer.MAX_VALUE);
        }
          while(!pq.isEmpty())
          {
            Pair res = pq.poll();
            int curr_row = res.row;
            int curr_col = res.col;
            int curr_cost = res.cost;
             if(curr_row == m-1 && curr_col == n-1)
             {
                return curr_cost;
             }
              for(int i = 0;i < 4;i++)
              {
                    int x = curr_row + dirs[i][0];
                    int y = curr_col + dirs[i][1];
                     if(x < 0 || y < 0 || x >= m || y >= n)
                     {
                        continue;
                     }

                     int cost = curr_cost + (i + 1 == grid[curr_row][curr_col] ? 0 : 1);
                     
                      if(cost < vis[x][y])
                      {
                          vis[x][y] = cost;
                          pq.add(new Pair(x,y,cost));
                       }
              }
          }
          return -1;
    }
}
  
