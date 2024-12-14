Q:-74 https://leetcode.com/problems/search-a-2d-matrix/description/
Company Tags                : Accolite, MentorGraphics, Adobe, Amazon, Directi, Goldman Sachs, Groupon,
                                  InMobi, MakeMyTrip, Ola Cabs, One97, Oracle, Paytm, Polycom,
                                  SAP Labs, Snapdeal, TinyOwl, Visa, Microsoft
************************************************************************************************************
//Approach- (Using Binary Search)
//Time Complexity:- O(log m*n)
---------------------------------------------------
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start <= end)
        {
            int mid = start+(end-start)/2;

            int row = mid/n;
            int col = mid%n;

            //int midValue = matrix[row][col];
            if( matrix[row][col] > target)
            {
                end = mid - 1;
            }
            else if(matrix[row][col] < target)
            {
                start = mid + 1;
            }
            else
            {
                return true;
            }

        }
        return false;
    }
}
