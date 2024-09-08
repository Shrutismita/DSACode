Q:- 90. https://leetcode.com/problems/subsets-ii/

T.C : O(2^n)
S.C : O(n)
  =====================================================================

  class Solution {
    List<List<Integer>> result = new ArrayList<>();
     void backTrack(int[] nums,int start,List<Integer> sub)
     {
        result.add(new ArrayList<>(sub));
        
        for(int i = start; i<nums.length; i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            sub.add(nums[i]);
            backTrack(nums,i+1,sub);
            sub.remove(sub.size() - 1);
        }
     }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<Integer> sub = new ArrayList<>();
         Arrays.sort(nums);
         backTrack(nums,0,sub);
         return result;
    }
}
