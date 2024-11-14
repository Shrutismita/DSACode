Q:- https://leetcode.com/problems/score-of-parentheses/
**************************************************************************
  class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(score);
                score = 0;
            }
            else
            {
               // when ever you meet a closing parantheses score will be updated
                score = st.pop() + Math.max(2*score,1);
            }
        }
        return score;
    }
}
