Q:- 3. https://leetcode.com/problems/longest-substring-without-repeating-characters/
================================================C#============================================
  public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int length = s.Length;
        int left = 0,right = 0;        
        int maxLength = 0;
         List<char> list = new List<char>();
        while(right < length)
        {
            if(list.Contains(s[right]))
            {
                list.Remove(s[left]);
                left ++;
            }
            else 
            {
                list.Add(s[right]);
                right++;
                maxLength = Math.Max(maxLength, right - left);
            }
        }
        return maxLength;
    }
}
