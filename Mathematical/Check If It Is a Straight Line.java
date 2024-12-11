Q:- https://leetcode.com/problems/check-if-it-is-a-straight-line/
 Company Tags                : Amazon
************************************************************************************
  class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
          if(coordinates.length<=2) return true;
        //[1,2], [2,3],[3,4]
        // First pair of point (x1, y2)
        //int x1 = coordinates[0][0];
        //int y1 = coordinates[0][1];

        // Second pair of point (x2, y2)
        //int x2 = coordinates[1][0];
        //int y2 = coordinates[1][1];

        int d_y = coordinates[1][1] - coordinates[0][1]; //y2-y1
        int d_x = coordinates[1][0] - coordinates[0][0]; //x2-x1

         /* 
          slope = d_y/d_x
         */

         for(int i = 2; i < n ; i++)
         {
            int d_y_i = coordinates[i][1] - coordinates[1][1];
            int d_x_i = coordinates[i][0] - coordinates[1][0];
             /* 
             slope = d_y_i/d_x_i
              d_y_i/d_x_i == d_y/d_x
              = d_y_i * d_x == d_x_i*d_y
            */
            if(d_y_i * d_x != d_x_i*d_y)
               return false;
         }
         return true;
    }
}
