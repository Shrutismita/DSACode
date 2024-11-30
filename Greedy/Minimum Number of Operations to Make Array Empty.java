Q:- https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
**********************************************************************************************************
//T.C : O(n)
//S.C : O(n)
-------------------------------------------------------
  class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;

        for(int i = 0; i < n; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> mp : map.entrySet())
        {
              int freq = mp.getValue();
              if(freq == 1)
              {
                 // we can only remove equal elements
                  return -1;
              }
                result += Math.ceil((double)freq / 3);
            }
            return result;
    }
}
