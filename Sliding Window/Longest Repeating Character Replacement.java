Q:- 424. https://leetcode.com/problems/longest-repeating-character-replacement/

=============================================================================================
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        int i = 0,j = 0, maxCount = 0 , result = 0;
        while(j < n)
        {
            char ch_j = s.charAt(j);
            map[ch_j - 'A']++;
            maxCount = Math.max(maxCount , map[ch_j - 'A']);
            //int windowSize = j - i +1;
            if(j - i +1 - maxCount > k)
            {
                char ch_i = s.charAt(i);
                map[ch_i - 'A']--;
                i++;
            }
            result = Math.max(result , j - i +1);
            j++;
        }
        return result;
    }
}
