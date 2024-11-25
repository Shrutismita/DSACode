Q:- https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
 Company Tags                : Google, Amazon, Microsoft, Adobe
*******************************************************************************************
  class Solution {
    class Pair
    {
        int plantTime;
        int growTime;
        Pair(int plantTime,int growTime)
        {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] flowerTime = new Pair[n];

         for(int i = 0; i < n;i++)
         {
            flowerTime[i] = new Pair(plantTime[i],growTime[i]);
         }
        Arrays.sort(flowerTime,(a,b)-> b.growTime - a.growTime);

         int prevPlantDays = 0;         
         int maxBloomDays  = 0;

        for(int i = 0; i<n; i++)
        {
             int currPlantTime = flowerTime[i].plantTime;
             int currGrowTime = flowerTime[i].growTime;

              // adding the plant time of ith seed to the plant times of preceeding seeds 
             // it would take prev_plant_time amount of time to actually plant the ith seed
             prevPlantDays += currPlantTime;

             // bloom time of ith seed = total plant time of ith seed + grow time of ith seed + 1 
            // (as the flower blooms after last day of it's growth)
            int currPlantBloomTime = prevPlantDays + currGrowTime;
            maxBloomDays = Math.max(maxBloomDays,currPlantBloomTime);
        }
        return maxBloomDays;
    }
}
