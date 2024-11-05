Q: - https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
**************************************************************************************************
  class Solution {
     int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
     Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {0, 0, k});
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int[] dpRow: dp) {
            Arrays.fill(dpRow, Integer.MIN_VALUE);
        }
        
        dp[0][0] = k;
        int steps = 0;  
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] curr = queue.poll();
                
                if (curr[0] == grid.length -1 && curr[1] == grid[0].length-1) {
                    return steps;
                }
                
                for(int[] dir: dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    if (isSafe(newX, newY, grid)) {
                        int newK = curr[2] - grid[newX][newY];
                        if (newK >=0 && newK > dp[newX][newY]) {
                            dp[newX][newY] = newK;
                            queue.add(new int[] {newX, newY, newK});
                        }
                    }
                }
                size--;
            }
            steps++;
        }
            
        return -1;
    }
    
    private boolean isSafe(int x, int y, int[][] grid) {
        return x >=0 && y >=0 && x<grid.length && y<grid[0].length;
    }
}
