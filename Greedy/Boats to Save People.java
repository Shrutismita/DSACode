Q:- https://leetcode.com/problems/boats-to-save-people/
 Company Tags                : Google
*********************************************************************************
  class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int n = people.length;
        Arrays.sort(people);
        int i = 0, j = n-1;
        int boats = 0;

        while(i <=j)
        {
           if(people[i] + people[j] <= limit )
           {
             i++;
             j--;
           }
           else
           {
            j--;
           }
           boats += 1;
        }
        return boats;
    }
}
