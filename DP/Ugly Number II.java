Q:- https://leetcode.com/problems/ugly-number-ii/
************************************************************************************
//Approach-1 (Recursion+Memo)(while submit got Time Limit Exceed)
//T.C : O(n * log k), where k is the number range to find the nth ugly number.
//S.C : O(u), where U is the number of distinct values stored in the memoization map mp.
class Solution {
    private Map<Integer, Boolean> mp = new HashMap<>();
    
    private boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        
        if (mp.containsKey(n)) {
            return mp.get(n);
        }
        
        if (n % 2 == 0 && isUgly(n / 2)) {
            mp.put(n, true);
            return true;
        } else if (n % 3 == 0 && isUgly(n / 3)) {
            mp.put(n, true);
            return true;
        } else if (n % 5 == 0 && isUgly(n / 5)) {
            mp.put(n, true);
            return true;
        }
        
        mp.put(n, false);
        return false;
    }
    
    public int nthUglyNumber(int n) {
        mp.clear();
        int num = 1;
        while (n > 0) {
            if (isUgly(num)) {
                n--;
            }
            num++;
        }
        
        return num - 1;
    }
}

==============================================================================================================
//Approach-2 (Bottom Up DP)
//T.C : O(n))
//S.C : O(n)
/*
    We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

    k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

    k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];
        // t[i] = ith Ugly number;
        // we will return t[n] = nth ugly number

        t[1] = 1; // 1st Ugly number

        int i2 = 1; // i2th Ugly number
        int i3 = 1; // i3rd Ugly number
        int i5 = 1; // i5th Ugly number

        for (int i = 2; i <= n; i++) {
            int i2th_ugly = t[i2] * 2;
            int i3rd_ugly = t[i3] * 3;
            int i5th_ugly = t[i5] * 5;

            t[i] = Math.min(Math.min(i2th_ugly, i3rd_ugly), i5th_ugly);

            if (t[i] == i2th_ugly) {
                i2++;
            }

            if (t[i] == i3rd_ugly) {
                i3++;
            }

            if (t[i] == i5th_ugly) {
                i5++;
            }
        }

        return t[n];
    }
}
