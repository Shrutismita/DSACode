Q:- https://leetcode.com/problems/poor-pigs/
********************************************************************************
//Approach-1
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int T = minutesToTest / minutesToDie + 1;
        int pigs = 0;

        while (Math.pow(T, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}

  
