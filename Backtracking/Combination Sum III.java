Q:- 216. https://leetcode.com/problems/combination-sum-iii/

T.C : O(2^n)
S.C : O(n)
  =========================================================================
  class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void backTrack(int num, int k,int target,  List<Integer> temp )
    {
         if(target == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if(num >= 10 || target < 0) {
            return;
        }

        for(int i = num; i<10; i++) {
            temp.add(i);
            backTrack(i+1,k, target-i,temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int num = 1;
        List<Integer> temp = new ArrayList<>();
        backTrack(num,k,n,temp);
        return result;
    }
}
