Q:- https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
  Company Tags  : Facebook, Amazon, Bloomberg, Google, tiktok, Adobe
  Frequency     : Facebook(111), Amazon(7), Bloomberg(4), Google(3), tiktok(2), Adobe(2)
*************************************************************************************************
 //Approach-1 (Using Stack and set)
//T.C : O(n)
//S.C : O(n) 
------------------------------------------------------------------------------
  class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
         
         int n = s.length();
         for(int i = 0; i < n; i++)
         {
             char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(i);
            }
            else if(ch == ')')
            { 
                if(st.isEmpty()) 
                {
                    set.add(i);
                }
                 else
                 {
                    st.pop();
                 }   

            }
        }
            while(!st.isEmpty())
            {
                 set.add(st.pop());
            }
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < n; i++) 
            {
                if(!set.contains(i))
                     result.append(s.charAt(i));
            }
        
        return result.toString();       
    }
}
====================================================================================================
//Approach-2 (Simplified : Playing smart and keeping it simple)
//T.C : O(n)
//S.C : O(n)
---------------------------------
  class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder temp = new StringBuilder();
         for(char c: s.toCharArray()) {
            if(c == '(') 
                open++;
            else if(c == ')') {
                if(open == 0)
                    continue;
                open--;
            }
            
            temp.append(c);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = temp.length() - 1; i >= 0; i--) {
            if(temp.charAt(i) == '(' && open-- > 0)
                continue;
            result.insert(0, temp.charAt(i));
        }
        
        return result.toString();   
    }
}

  
