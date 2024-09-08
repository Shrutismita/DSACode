Q: - 40. https://leetcode.com/problems/combination-sum-ii/

T.C : O(2^n)
S.C : O(n)
  =============================================================================
  class Solution {
    int n;
    public void backTracke(int[] candidates, int target, List<List<Integer>> result,List<Integer> currSum, int idx) 
    {
       if(target < 0)return;
       if(target == 0)
       {
          result.add(new ArrayList<>(currSum));
          return;
       }
       for(int i = idx; i < candidates.length; i++)
       {
        if(i > idx && candidates[i] == candidates[i-1])
        {
            continue;
        }
         currSum.add(candidates[i]);
         backTracke(candidates,target - candidates[i],result,currSum,i+1);
         currSum.remove(currSum.size() - 1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          n = candidates.length;
          List<List<Integer>> result = new ArrayList<>();
          List<Integer> currSum = new ArrayList<>();
          Arrays.sort(candidates);
          backTracke(candidates,target,result,currSum,0);
          return result;
    }
}
