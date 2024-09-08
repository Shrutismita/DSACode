Q:- 78. https://leetcode.com/problems/subsets/
T.C - O(2^n)
  S.C - O(n)
  ===========================================================
  class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void backTrack(int[] nums, int i , List<Integer> temp)
    {
        if(i >= nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        backTrack(nums, i+1, temp);
        temp.remove(temp.size() - 1);
        backTrack(nums,i+1,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        backTrack(nums,0,temp);
        return result ;
    }
}
