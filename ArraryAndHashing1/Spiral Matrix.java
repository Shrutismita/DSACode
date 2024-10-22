Q:- https://leetcode.com/problems/spiral-matrix/
 Company Tags                 : Paytm, Zoho, Morgan Stanley, Accolite, Amazon, Microsoft, Snapdeal, 
                                D-E-Shaw, MakeMyTrip, Oracle, MAQ Software, nearbuy, Nagarro, BrowserStack
************************************************************************************************************************
//Time complexity: O(n * m)
//Space complexity: O(n * m)
---------------------------------------------------------
  class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int top   = 0;
        int down  = m-1;
        int left  = 0;
        int right = n-1;

        int id = 0;
        //id
        //0   -> left  to right
        //1   -> top   to down
        //2   -> right to left
        //3   -> down  to top
         while(top <= down && left <= right) 
         {
            //left to right
            if(id == 0) {
                for(int i = left; i<=right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            
            //top to down
            if(id == 1) {
                for(int i = top; i<=down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
             //right to left
            if(id == 2) {
                for(int i = right; i>=left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            
            //down to top
            if(id == 3) {
                for(int i = down; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            
            id = (id+1)%4;
         }
         return result;
    }
}
  
