Q:- 567. https://leetcode.com/problems/permutation-in-string/
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
