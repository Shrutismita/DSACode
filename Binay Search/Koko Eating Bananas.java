Q:- https://leetcode.com/problems/koko-eating-bananas/
 Company Tags                : Google, Miscrosoft
 ***************************************************************************************************************
  //Binary Search - Using same concept as "Leetcode-2187 : Minimum Time to Complete Trips"
  //ime complexity: O(nlogm) where n is the number of piles and m is the maximum number of bananas in a pile.
 ---------------------------------------------------------------------------------------------------
  class Solution {
    boolean canEatAll(int[] piles, int givenHour, int h)
    {
        int actualHour = 0;
        for(int pile : piles)
        {
            actualHour += pile/givenHour;
            if(pile%givenHour != 0)
                actualHour++;
        }
        return actualHour <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max_piles = 0;
        for(int pile: piles)
        {
            max_piles = Math.max(max_piles,pile);
        }
        int r = max_piles;
        while(l < r)
        {
            int mid = l + (r-l)/2;
            if(canEatAll(piles,mid,h))
            {
                r = mid;
            }
            else
            {
                l = mid+1;
            }
        }
        return l;
    }
}
