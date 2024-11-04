Q:- https://leetcode.com/problems/partition-equal-subset-sum/
*******************************************************************************
  class Solution {
     static boolean subsetSumTarget(int arr[], int n, int sum) {
        boolean[] prev = new boolean[n+1];
        Arrays.fill(prev, true);
        
        for(int i=0; i<n+1; i++){
            boolean[] curr = new boolean[sum+1];
            
            for(int j=0; j<sum+1; j++){
                if((i==0 || i!=0) && j==0) curr[j] = true;
                else if(i==0 && j!=0) curr[j] = false;
                else
                    if(arr[i-1] <= j) curr[j] = prev[j] || prev[j-arr[i-1]];
                    else curr[j] = prev[j];
            }
            prev = curr;
        }
        
        return prev[sum];
   }
    public boolean canPartition(int[] nums) {
          int n = nums.length;
          int total = 0;
        for(int i=0; i<n; i++) 
             total += nums[i];
        if(total % 2 == 1) return false;
        
        int target = total/2;
        return subsetSumTarget(nums, n, target);
    }
}
