Q:- https://leetcode.com/problems/longest-turbulent-subarray/
*********************************************************************************
  class Solution {
    public int maxTurbulenceSize(int[] arr) {
         int n = arr.length, ans = 1;

        int seq = 1;// Seq = Current Sequence Length & turb = -1, 0, 1 for <, =, > respectively
        int turb = 0;             
        
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] > arr[i+1]) {                 // If arr[i+1] is less than arr[i]  
                if(turb >= 0) seq += 1;             // Add 1 to seq if the turbulence is still forming at ith element
                else seq = 2;                       // Otherwise seq will be 2 
                turb = -1;
            }
            else if(arr[i] < arr[i+1]) {
                if(turb <= 0) seq += 1;
                else seq = 2;
                turb = 1;
            }
            else {
                seq = 1;
                turb = 0;
            }

            ans = Math.max(ans, seq);
        }

        return ans;
    }
}
