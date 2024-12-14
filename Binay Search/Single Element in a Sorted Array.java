Q:- https://leetcode.com/problems/single-element-in-a-sorted-array/
  Company Tags                : Amazon, D-E-Shaw, Ola Cabs, Codenation, Qualcomm, Microsoft
  **********************************************************************************************************
  //Approach : 1 (Using XOR operator) 
  //T.C. : O(n)
  -----------------------------------------------
  class Solution {
    public int singleNonDuplicate(int[] nums) {
         int xor_Value = 0;
        
        for(int num : nums) {
            xor_Value ^= num;
        }
        
        return xor_Value;
    }
}
===============================================================================================================================
  //Approach : 2 (Using Binary Search)
  //T.C: O(log(n))
  ----------------------------------------------------------------------
  class Solution {
    public int singleNonDuplicate(int[] nums) {
         int n = nums.length;
         int l = 0, r = n - 1;
         int mid = 0;
          while(l < r)
          {
            mid = l + (r-l)/2;
             boolean isEven = (r-mid)%2==0;
            
            if(nums[mid] == nums[mid+1]) {
                if(isEven) {
                    l = mid+2;
                } else {
                    r = mid-1;
                }
            } else if(nums[mid] == nums[mid-1]) {
                if(isEven) {
                    r = mid-2;
                } else {
                    l = mid+1;
                }
            } else {
                return nums[mid];
            }
        }
        
        return nums[l]; //or, nums[r]
    }
}
