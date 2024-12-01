Q:- : PART-1 : https://leetcode.com/problems/minimum-cost-for-cutting-cake-i/description/
      PART-2 : https://leetcode.com/problems/minimum-cost-for-cutting-cake-ii/description/
*************************************************************************************************************************
 //Greedy Approach
//T.C : O(xlog + ylogy) where x and y are lengths of horizontal and vertical cuts array
//S.C : O(1)
---------------------------------------------------------------------------------------------------
  class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int x = horizontalCut.length;
        int y = verticalCut.length;
        
        Arrays.sort(horizontalCut); // Sort in ascending order and iterate from right to left to process larger cost first
        Arrays.sort(verticalCut);   // Sort in ascending order and iterate from right to left to process larger cost first
        
        int i = x - 1, j = y - 1; // Start from the largest elements
        int horizontalPieces = 1, verticalPieces = 1;
        int result = 0;

        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] >= verticalCut[j]) {
                result += horizontalCut[i] * verticalPieces;
                horizontalPieces++;
                i--;
            } else {
                result += verticalCut[j] * horizontalPieces;
                verticalPieces++;
                j--;
            }
        }

        while (i >= 0) {
            result += horizontalCut[i] * verticalPieces;
            horizontalPieces++;
            i--;
        }

        while (j >= 0) {
            result += verticalCut[j] * horizontalPieces;
            verticalPieces++;
            j--;
        }

        return result;

    }
}
