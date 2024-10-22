Q:- https://leetcode.com/problems/rotate-image/
Company Tags : Amazon, DE-Shaw, Microsoft, Morgan Stanley, Paytm, Samsung, Snapdeal, Zoho
********************************************************************************************************
//Time complexity: O(N^2)
//Space complexity: O(N)
-----------------------------------------------------------
  class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
         // transpose of matrix
           for (int i = 0; i < m; i++) 
           {
              for (int j = 0; j < i; j++)
              {  
                int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;
               }
            } 

          // for reversing the row of transposed matrix 
          for(int i = 0; i < n; i++)
          {
             int start = 0;
            int end = matrix.length-1;
            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                end--;
                start++;
            }
          }       
    }
}
