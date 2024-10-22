Q:- https://leetcode.com/problems/find-original-array-from-doubled-array/
 Company Tags : Google,
 *******************************************************************************
 //Approach- (Using sorting and map) 
//Time Complexity: O(NlogN)
//Space Complexity: O(N)
---------------------------------------------------------------------
  class Solution {
    public int[] findOriginalArray(int[] changed) {
      int len = changed.length;
        if (len%2==1) return new int[]{};
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(changed);
        for (int i : changed) {
            if (i%2==0) {
                int count = 0;
                if ((count = map.getOrDefault(i/2, 0))!=0) {
                    res.add(i/2);
                    map.put(i/2, count-1);
                } else {
                    map.put(i, map.getOrDefault(i, 0)+1);
                }
            } else {
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }
        if (res.size()<len/2) return new int[]{};
        else {
            int[] out = new int[res.size()];
            for (int i=0; i<out.length; i++) {
                out[i] = res.get(i);
            }
            return out;
        }
    }
}
