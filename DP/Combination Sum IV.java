Q:- https://leetcode.com/problems/combination-sum-iv/
*********************************************************************
  class Solution {
    public int solve(int target,int nums[], Integer res[]){
        
        if(target == 0){
            return 1;
        }
        
        if(target <0){
            return 0;
        }
        if(res[target] != null)
            return res[target];
        int count = 0;
        for(int i =0;i<nums.length;i++){
            count+= solve(target - nums[i],nums,res);
        }
        return res[target] = count;       
    }
    public int combinationSum4(int[] nums, int target) {
        Integer[] res = new Integer[target+1];
        return solve(target,nums, res);
    }
}
