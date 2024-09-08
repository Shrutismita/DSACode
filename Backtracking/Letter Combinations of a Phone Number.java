Q:- 17. https://leetcode.com/problems/letter-combinations-of-a-phone-number/

T.C - O(4^n)
  S.C - O(n)
  ======================================================================================
  class Solution {
    List<String> result = new ArrayList<>();
    void backTrack(String s, int idx, StringBuilder temp,Map<Character,String> map)
    {
        if(idx >= s.length())
        {
            result.add(temp.toString());
            return ;
        }
        char ch = s.charAt(idx);
        String str = map.get(ch);
        for(int i = 0 ; i < str.length(); i++)
        {
            temp.append(str.charAt(i));
            backTrack(s, idx + 1, temp,map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
       map.put('6',"mno");
       map.put('7',"pqrs");
       map.put('8',"tuv");
       map.put('9',"wxyz");
       
       StringBuilder temp = new StringBuilder();
      backTrack(digits,0,temp,map);
      return result;
    }
}
