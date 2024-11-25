Q:- https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
*************************************************************************************************
  class Solution {
    public int longestPalindrome(String[] words) {
         int len = 0;
         Map<String, Integer> mp = new HashMap<>();

        // Count frequencies of each word
        for (String s : words) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        boolean appendMiddle = false;

        // Process each word and its reverse
        for (String word: mp.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (word.equals(rev)) {
                // Word is a palindrome itself
                int count = mp.get(word);
                if (count % 2 == 0) {
                    len += count * 2;
                } else {
                    len += (count - 1) * 2;
                    appendMiddle = true;
                }
            } else if (mp.containsKey(rev)) {
                // Word and its reverse form pairs
                int count1 = mp.get(word);
                int count2 = mp.get(rev);
                int pairs = Math.min(count1, count2);
                len += pairs * 4;
                // Mark these words as used by setting their count to 0
                mp.put(word, count1 - pairs);
                mp.put(rev, count2 - pairs);
            }
        }

        // Add 2 if there's a middle element possible
        if (appendMiddle) {
            len += 2;
        }

        return len;
    }
}
