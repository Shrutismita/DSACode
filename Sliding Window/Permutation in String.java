Q:- 567. https://leetcode.com/problems/permutation-in-string/
Company Tags                : Microsoft, Amazon
************************************************************************************************
//Approach-1 (Using Sorting and Comparing) - ACCEPTED
//T.C : O((m-n) * nlogn)
//S.C : O(n)
-----------------------------------------------------------
  class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

         // If s1 is longer than s2, it cannot be a substring
        if(n > m) 
             return false;

        // Sort the string s1
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);

        // Iterate over each substring of s2 of length equal to s1
        for(int i = 0; i <= m-n; i++)
        {
             // Extract a substring of length n from s2 starting at index i
             String temp = s2.substring(i, i+n);

             // Sort the substring
             char[] sortedTemp = temp.toCharArray();
             Arrays.sort(sortedTemp);

              // If the sorted substring matches the sorted s1, return true
              if(Arrays.equals(sortedS1,sortedTemp))
                       return true;
        }

         // No permutation found in s2
        return false;
    }
}
==================================================================================================
//Approach-2 (Sliding Window) - ACCEPTED
//T.C : O(m+n)
//S.C : O(26)
---------------------------------------------------
  class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

         // If s1 is longer than s2, it cannot be a substring
        if(n > m) 
             return false;

        // Frequency arrays for s1 and the current window in s2
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        for(int i = 0 ; i < n ; i++)
        {
            s1_freq[s1.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        int i = 0; // left index of the sliding window
        int j = 0; // right index of the sliding window

        while(j < m)
        {
            // Include a new character from the right end of the window
            s2_freq[s2.charAt(j) - 'a']++;

            // Check if the current window size matches the size of s1
            if (j - i + 1 > n) {
                // If we have passed the size of s1, we need to remove the leftmost character
                s2_freq[s2.charAt(i) - 'a']--;
                i++;
            }
           // Check if the current window's frequency matches s1's frequency
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }

           j++;
        }

        return false;
    }
}
===================================================C#==========================
  public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        Dictionary<char,int> charCounts = new Dictionary<char,int>();
        int left = 0; int right = left - s1.Length;
        foreach(char c in s1)
        {
            if(charCounts.ContainsKey(c))
            {
                charCounts[c]++;
            }
            else
            {
                charCounts[c] = 1;
            }
        }
        while (left < s2.Length)
        {
            if(charCounts.ContainsKey(s2[left]))
            {
                charCounts[s2[left]]--;
            }
            if(right >= 0 && charCounts.ContainsKey(s2[right]))
            {
                charCounts[s2[right]]++;
            }
            left++;
            right++;
            if(charCounts.Values.All(x=> x == 0))
            {
                return true;
            }
        }
        return false;
    }
}
