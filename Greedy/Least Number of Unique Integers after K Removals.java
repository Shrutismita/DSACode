Q:- https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
  Company Tags                : Amazon
***************************************************************************************************************
//Approach-1 (Using Map and Sorting)
//T.C : O(nlogn)
//S.C : O(n)
--------------------------------------------------------
  class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            freq.add(entry.getValue());
        }

        Collections.sort(freq);

        for (int i = 0; i < freq.size(); i++) {
            k -= freq.get(i);

            if (k < 0) {
                return freq.size() - i;
            }
        }

        return 0; // All were removed
    }
}
=============================================================================================
//Approach-2 (Using Counting Sort)
//T.C : O(n)
//S.C : O(n)
-------------------------------------------
  class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        int[] freqCount = new int[n+1];
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            freqCount[entry.getValue()]++;
        }

        int result = mp.size();

        for (int i = 1; i <= n; i++) {
             if(k < freqCount[i] * i)
             {
                result -= (k/i);
                break;
             }
             else
             {
                k -= freqCount[i]*i;
                result -= freqCount[i];
             }
        }

        return result;
    }
}
