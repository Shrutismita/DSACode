Q:- https://leetcode.com/problems/find-in-mountain-array/
Company Tags                : AMAZON
*********************************************************************************************
//Approach - Solving using Binary Search
//T.C : log(n)
//S.C : O(1)
-------------------------------------------------------------
  class Solution {
    public int peakIndexInMountainArray(MountainArray mountainArr)
    {
        int n = mountainArr.length();
        int l = 0;
        int r = n-1;
        while(l<r)
        {
            int mid = l + (r-l)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1))
            {
                l= mid+1;
            }
            else
            {
                r = mid;
            }
        }
        return l;
    }
    public int binarySearch(MountainArray mountainArr, int l, int r, int target)
    {
        while(l <= r)
        {
            int mid = l +(r-l)/2;
            if(mountainArr.get(mid) == target)
            {
                return mid;
            }
            else if(mountainArr.get(mid) > target)
            {
                r = mid -1; 
            }
            else
            {
                l = mid+1;
            }
        }
        return -1;
    }
     public int reverseBinarySearch(MountainArray mountainArr, int l, int r, int target)
     {
        while(l <= r)
        {
            int mid = l +(r-l)/2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) { // Because the array in the right side of the peak is in descending order
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return -1;
     }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = peakIndexInMountainArray(mountainArr);

        //0-peakIndex
        int idx = binarySearch(mountainArr,0,peakIndex,target);
        if(idx == -1)
        {
            return reverseBinarySearch(mountainArr,peakIndex,n-1,target);
        }
        return idx;
    }
}
