Q: Count Occurences of Anagrams
https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
Company Tags    		: Amazon, Intuit, Microsoft, Flipkart
*************************************************************************************************    
//Time Complexity: O(N)
//Space Complexity: O(1)
========================================================================================================
Ans: write the code using Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int n = txt.length();
        int[] txtFrequency = new int[26];
         for (char ch : pat.toCharArray()) {
            txtFrequency[ch - 'a']++;
        }
        
        int i = 0, j = 0;
        int result = 0;
        int k = pat.length();
        while(j<n)
        {
            txtFrequency[txt.charAt(j) - 'a']--;
            if(j-i+1 == k)
            {
                if(allZero(txtFrequency))
                {
                    result++;
                }
                txtFrequency[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
    boolean allZero(int[] txtFrequency)
    {
         for (int num : txtFrequency) {
            if (num != 0) 
                return false;
            }
        return true;
    }
}
 
