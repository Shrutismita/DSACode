Q:- https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
*************************************************************************************************************
//Approach- (Using Binary Search)
//T.C : O(m * log maxValue)
//S.C : O(1)
----------------------------------------------------------------------------------
  class Solution {
    boolean possibleToDistribute(int x, int[] quantities,int n)
    {
        for(int product : quantities)
        {
            n -= (product + x - 1)/x ; //Math.ceil((double)product/x)
            if(n < 0)
            {
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        int result = 0;
        while(l <= r)
        {
            int mid = l +(r-l)/2; //x
            if(possibleToDistribute(mid,quantities,n))
            {
                result = mid;
                r = mid -1;
            }
            else
            {
                l = mid+1;
            }
        }
        return result;
    }
}
  
