Q:- https://leetcode.com/problems/largest-divisible-subset/
****************************************************************************************
//Approach-1 (Using Bottom Up same as LIS) - Just need to keep track of how to print LIS
//T.C : O(n^2)
//S.C : O(n)
------------------------------------------------------------------
  class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      int n = nums.length, maxLength = 0, index = -1;
        int[] lisLength = new int[n];
        int[] prevIndex = new int[n];
        for(int i=0; i<n; i++){
            lisLength[i] = 1;
        }
        for(int i=0; i<n; i++){
            prevIndex[i] = -1;
        }
        Arrays.sort(nums);
        for(int i=0;i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] == 0 && 1+lisLength[j] > lisLength[i]){
                    lisLength[i] = 1+lisLength[j];
                    prevIndex[i] = j;
                }
            }
            if(lisLength[i] > maxLength){
                maxLength = lisLength[i];
                index = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(index != -1){
            ans.add(nums[index]);
            index = prevIndex[index];
        }
        return ans;
    }
}

  
