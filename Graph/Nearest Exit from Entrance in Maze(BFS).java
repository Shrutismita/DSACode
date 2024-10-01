Q:- https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
//T.C  - O(m*n)
//S.C - O(m+n)
===========================================================================================================================
  class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

         // As simple 2D array to keep track of the directions to take.
        // We can use 4 separate operation, but it is more efficient to use a for-loop to go through the four directions.
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int rows = maze.length;

        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(entrance);
        maze[entrance[0]][entrance[1]] ='+'; //marking it visited

       int steps = 0;

       while(!queue.isEmpty())
       {
           steps++;
           int n = queue.size();
            // Check every node at the current step.
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();
                // For each node, check every direction.
                for(int[] direction : directions)
                {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    // Check if this direction out of bound.
                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    // Check if this direction is the wall.
                    if (maze[x][y] == '+') continue;

                    // If this direction is empty, not visited and is at the boundary, we have arrived at the exit.
                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;

                    // Otherwise, we change this direction as visited and put into the queue to check at the next step.
                    maze[x][y] = '+';
                    queue.add(new int[]{x, y});
                }
            }
             
       }
       return -1;
    }
}
