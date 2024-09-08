Q:- 46. https://leetcode.com/problems/permutations/
T.C- O(n*n!)
  S.C-  O(n)
  =======================================================
  class Solution {
      List<List<Integer>> result = new ArrayList<>();
      int n;
      
       void solve(int[] nums, List<Integer> temp)
       {
        if(temp.size() == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        for(int i = 0 ; i < nums.length; i++)
        {
                 if(temp.contains(nums[i])) continue;
                 
                    temp.add(nums[i]);                    
                    solve(nums,temp);
                    temp.remove(temp.size() - 1);
                    
                 
        }

       }
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(nums,temp);
        return result;
    }
}
