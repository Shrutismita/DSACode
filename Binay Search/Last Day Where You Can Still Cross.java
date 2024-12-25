Q:- https://leetcode.com/problems/last-day-where-you-can-still-cross/
Company Tags                : GOOGLE (on site interview), META
****************************************************************************************
  //Approach-1 (Using Binary Search + DFS)
  ------------------------------------------------------
  class Solution {
    int ROW;
    int COL;
    int[][] directions =new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    boolean dfs(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1)
        {
            return false;
        }
        if(i == ROW-1)
            return true;

          grid[i][j] = 1;
        for(int[] dir : directions)
        {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            
            if(dfs(grid, new_i, new_j))
                return true;
        }  
        return false;
    }
    boolean canCross(int[][] cells,int mid)
    {
        int[][] grid = new int[ROW][COL];
        for(int i = 0; i <= mid; i++)
        {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;

            grid[x][y] = 1;
        }
        for(int j = 0; j <COL; j++)
        {
            if(grid[0][j] == 0 && dfs(grid,0,j))
            {
                return true;
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
            ROW = row;
            COL = col;
            int l = 0;
            int r = cells.length - 1;
            int lastDay = 0;
            while(l <= r)
            {
                int mid = l + (r-l)/2;
                if(canCross(cells,mid))
                {
                    lastDay = mid+1;
                    l = mid+1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            return lastDay;   
    }
}
=============================================================================================
  //Approach-2 (Binary Search + BFS)
  ------------------------------------------------
  class Solution {
    int ROW;
    int COL;
    int[][] directions =new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    boolean bfs(int[][] grid, int i, int j)
    {
           Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{i, j});
            grid[i][j] = 1;  
            while(!que.isEmpty()) {
            
            int[] temp = que.poll();
                       
            int x = temp[0];
            int y = temp[1];
            
            if(x == ROW-1)
                return true;
            
            for(int[] dir : directions) {
                
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                
                if(new_x >= 0 && new_x < ROW && new_y >= 0 && 
                      new_y < COL && grid[new_x][new_y] == 0) {
                    que.add(new int[]{new_x, new_y});
                    grid[new_x][new_y] = 1;
                }
                
            }
            
        }
        
        return false; 
    }
    boolean canCross(int[][] cells,int mid)
    {
        int[][] grid = new int[ROW][COL];
        for(int i = 0; i <= mid; i++)
        {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;

            grid[x][y] = 1;
        }
        for(int j = 0; j <COL; j++)
        {
            if(grid[0][j] == 0 && bfs(grid,0,j))
            {
                return true;
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
            ROW = row;
            COL = col;
            int l = 0;
            int r = cells.length - 1;
            int lastDay = 0;
            while(l <= r)
            {
                int mid = l + (r-l)/2;
                if(canCross(cells,mid))
                {
                    lastDay = mid+1;
                    l = mid+1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            return lastDay;   
    }
}
===========================================================================================
  //Approach-3 (Using Union Find)
  ---------------------------------------
  class Solution {
    int lastRow;
    int firstRow;
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        // Flip the grid on the diagonal.
        int temp = row;
        row = col;
        col = temp;
        
        int rW = col + 2;   // Width of a row in parents[] array.
        int rWM1 = rW - 1;
        int rWP1 = rW + 1;
        lastRow = row * rW;
        firstRow = 2 * rW - 1;
        
        int[] parents = new int[(row + 2) * (col + 2)];
        
        for (int cellsIdx = 0; ; cellsIdx++) {
            int cell = cells[cellsIdx][1] * rW + cells[cellsIdx][0];
            parents[cell] = cell;
            if ((parents[cell - rWM1]     != 0 && union(parents, cell, cell - rWM1)) || 
                    (parents[cell - rW]   != 0 && union(parents, cell, cell - rW))   || 
                    (parents[cell - rWP1] != 0 && union(parents, cell, cell - rWP1)) || 
                    (parents[cell - 1]    != 0 && union(parents, cell, cell - 1))    || 
                    (parents[cell + 1]    != 0 && union(parents, cell, cell + 1))    ||
                    (parents[cell + rWM1] != 0 && union(parents, cell, cell + rWM1)) || 
                    (parents[cell + rW]   != 0 && union(parents, cell, cell + rW))   || 
                    (parents[cell + rWP1] != 0 && union(parents, cell, cell + rWP1)))
                return cellsIdx;
        }
    }
    
    
    private boolean union(int[] parents, int newCell, int oldCell) {
        int newPar = findParent(parents, newCell);
        int oldPar = findParent(parents, oldCell);
        if (newPar != oldPar) {
            if (newPar <= firstRow) {
                if (oldPar >= lastRow)  return true;
                parents[oldPar] = newPar;
            } else if (newPar >= lastRow) {
                if (oldPar <= firstRow)  return true;
                parents[oldPar] = newPar;
            } else
                parents[newPar] = oldPar;
        }
        return false;
    }
    
    
    private int findParent(int[] parents, int cell) {
        if (parents[cell] == cell)  return cell;
        return (parents[cell] = findParent(parents, parents[cell]));
    }
}
