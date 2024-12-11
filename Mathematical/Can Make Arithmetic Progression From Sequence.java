Q:- https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
Company Tags                : GOOGLE
**********************************************************************************************
  //Approach-1 (Using Sorting (O(nlogn))
  ---------------------------------------------
  class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i = 2; i < n; i++)
        {
            if((arr[i]-arr[i-1]) != d)
            {
                return false;
            }
        }
        return true;
    }
}
==========================================================================================
  //Approach-2 (Using Mathematival AP property - O(n) Time, O(n) Space))
  ---------------------------------------------------------------------------
  class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int min_el = Integer.MAX_VALUE;
        int max_el = Integer.MIN_VALUE;
        for (int val : arr) {
            min_el = Math.min(val, min_el);
            max_el = Math.max(val, max_el);
            set.add(val);
        }

         if((max_el - min_el)%(n-1) != 0)
               return false;
               
        int d = (max_el - min_el)/(n-1);
        
        int i = 0; 
        //a0 , a0+d , a0 + 2d
        
        while(i < n) {
            int num = min_el + i*d;
             if (!set.contains(num)) 
                return false;
            
            i++;
        }

        return true;
    }
}
===========================================================================================
  //Approach-3 (Using O(1) Space and O(n) Time)
  ------------------------------------------------------
  class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int min_el = Integer.MAX_VALUE;
        int max_el = Integer.MIN_VALUE;
        for (int val : arr) {
            min_el = Math.min(val, min_el);
            max_el = Math.max(val, max_el);
            set.add(val);
        }

         if((max_el - min_el)%(n-1) != 0)
               return false;

        int d = (max_el - min_el)/(n-1);
        
        int i = 0; 
        //a0 , a0+d , a0 + 2d
        
        while(i < n) {
             if(arr[i] == min_el + i*d) {
                i++;
            } else {
                
                if((arr[i] - min_el) % d != 0)
                    return false;
                
                int j = (arr[i] - min_el)/d;
                
                if(arr[i] == arr[j])
                    return false;                
               
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return true;
    }
}
