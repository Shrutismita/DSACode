Q:- https://leetcode.com/problems/add-digits/
 Company Tags                : Adobe, Microsoft
*************************************************************************************************
  //Approach-1 (Brute Force)
  -------------------------------------
  class Solution {
    int sum ;
    int CountDigit(int num)
    {
        int count = 0;
         sum = 0;
        while(num != 0)
        {
            sum += num%10;
            num = num/10;
            count++;
        }
        return count;
    }
    public int addDigits(int num) {
        while(CountDigit(num) > 1)
        {
            num = sum;
        }
        return sum;
    }
}
==================================================================================================
  //Approach-2 (Using Maths)
  ------------------------------------------
  class Solution {
    public int addDigits(int num) {
       if(num == 0) return 0;
       int result = num%9;
       if(result == 0) return 9;
       
       return result;
    }
}
