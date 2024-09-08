Q:- 39 https://leetcode.com/problems/combination-sum/

T.C : O(2^n)
S.C : O(n)
============================================================================
  class Solution {
    void backTrake(int[] candidates, int target, List<Integer> currSum, List<List<Integer>> result, int idx) {
       if(target < 0)return ;
       if(target == 0)
       {
        result.add(new ArrayList<>(currSum));
        return;
       }
       for(int i = idx; i < candidates.length; i++)
       {
            currSum.add(candidates[i]);
            backTrake(candidates, target-candidates[i], currSum, result, i);
            currSum.remove(currSum.size() - 1);
       }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSum = new ArrayList<>();
        backTrake(candidates,target, currSum, result,0);
        return result;
        
    }
}
