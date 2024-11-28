Q:- https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 Company Tags                : Google
**************************************************************************************************************
//T.C :- O(n)
----------------------------------------------------
  class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0;
        int bob = 0;
        for(int i = 1; i < n-1; i++)
        {
                if(colors.charAt(i-1) == colors.charAt(i) && 
                    colors.charAt(i) == colors.charAt(i+1))
                {
                    if(colors.charAt(i) == 'A')
                       alice++;
                     else
                        bob++;  
                }
        
        }
       return alice > bob;
    }
}
