Q: - 438 https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
Company Tags  : Microsoft, Google, Amazon
******************************************************************************************************   
//T.C:- O(n)
//T.C:- O(n)
-------------------------------------------------------------    
class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
    int n = txt.length();
        int[] txtFrequency = new int[26];
         for (char ch : pat.toCharArray()) {
            txtFrequency[ch - 'a']++;
        }
        
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        int k = pat.length();
        while(j<n)
        {
            txtFrequency[txt.charAt(j) - 'a']--;
            if(j-i+1 == k)
            {
                if(allZero(txtFrequency))
                {
                    result.add(i);
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
