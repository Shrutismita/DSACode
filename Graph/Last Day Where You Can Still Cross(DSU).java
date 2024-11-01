Q:- https://leetcode.com/problems/last-day-where-you-can-still-cross/
*************************************************************************************
//Using DisjointSet(DSU)
------------------------------
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
