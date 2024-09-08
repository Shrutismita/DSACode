Q:- 47. https://leetcode.com/problems/permutations-ii/
T.C - O(n*n!)
  S.C - O(n)
  ===================================================================

  class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n ; 
    void backTrack(List<Integer> temp, Map<Integer,Integer> map)
    {
        if(temp.size() == n)
        {
            result.add(new ArrayList<>(temp));            
            return ;
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int num = entry.getKey();
            int count = entry.getValue();

            if(count == 0) continue;
            temp.add(num);
            map.put(num, count - 1);
            backTrack(temp, map);
            temp.remove(temp.size() - 1);
            map.put(num,count);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
         n = nums.length;
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        backTrack(temp,map);
        return result;
    }
}
