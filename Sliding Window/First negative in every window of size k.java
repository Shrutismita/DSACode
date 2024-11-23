Q:- https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
  Company Tags                : Amazon, MentorGraphics
 **********************************************************************************************************
  class Solution {
    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        int n = arr.length;
         List<Integer> result = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         int i = 0, j = 0;
         
         while(j < n)
         {
             if(arr[j] < 0)
             {
                 temp.add(arr[j]);
             }
             if(j-i+1 == k)
             {
                 int neg = temp.isEmpty() ? 0 : temp.get(0);
                 result.add(neg);
                 if(arr[i] < 0 && !temp.isEmpty())
                 {
                     temp.remove(0);
                 }
                 i++;
             }
             j++;
         }
         return result;
    }
}
