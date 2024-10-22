Q:- https://leetcode.com/problems/sort-colors/
   Company Tags : Adobe, Amazon, Hike, MakeMyTrip, MAQ Software, Microsoft, Morgan Stanley, Ola Cabs,
                  OYO Rooms, Paytm, Qualcomm, Samsung, SAP Labs, Snapdeal, Walmart, Yatra.com, Flipkart
*********************************************************************************************************************
// Approach- (Follow up)
// T.C : O(n)
// S.C : O(1)
----------------------------------------------
  class Solution {
    public void sortColors(int[] nums) {
    int n = nums.length;

        int i = 0;   // denotes for 0
        int j = 0;   // denotes for 1
        int k = n - 1; // denotes for 2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else { // nums[j] == 0
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}
