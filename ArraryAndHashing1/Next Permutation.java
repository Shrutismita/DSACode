Q:- https://leetcode.com/problems/next-permutation/
Company Tags: Amazon, FactSet, Hike, Amazon, MakeMyTrip, Qualcomm, Infosys, Microsoft, Google, Salesforce, Flipkart
*************************************************************************************************************************  
//Approach - Using Two Pointer
//Time complexity: O(n)
//Space complexity:O(1)
----------------------------------------------------
  class Solution {
     public void reverse( int[] nums , int left , int right ){
        while( left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
       int index = -1;
        int n = nums.length;

        // Finding the first dip of the array
        for( int i = n - 2 ; i >= 0 ; i-- ){
            if( nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }   

        // If there is no dip in the array just reverse it
        
        if( index == -1 ){
            reverse(nums , 0 , n-1);
            return;
        }

        // If the dip is found,
        // Now we have find the element that is greater and close to the value of index

        for( int i = n - 1 ; i > index ; i-- ){
            if( nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        // Now after the value that is next than index it will be in increasing order from last 
        // Reverse that particular array from ( index + 1 ) -> nums.size() - 1

        reverse( nums , index + 1 , n - 1);
    }
}
