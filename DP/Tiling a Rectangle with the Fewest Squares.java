Q:- https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
*******************************************************************************************
  class Solution {
    private int calcHelper(int s, int l, int[][] memo) 
    {
         if(s > l) return calcHelper(l, s, memo); //short, long   
    
          //base cases
          if(s == 0) return 0;
           if(s == 1) return l; //all 1x1 squares
           if(s == l) return 1; //1 square
           if(memo[s][l] > 0) return memo[s][l];

           int res = Integer.MAX_VALUE;
           int maxSize = Math.min(s,l); 
            for(int w = 1; w <= maxSize; ++w)
            {
                for(int i = 0; i <= l-w; ++i)
                {
                    for(int j = 0; j <= s-w; ++j)
                    {
                         res = Math.min(res, 
                             1 + calcHelper(i+w, s-j-w, memo) +
                              calcHelper(i, j+w, memo) + calcHelper(s-j, l-i-w, memo) +
                               calcHelper(l-i, j, memo));
                    }
                }
            }    
              memo[s][l] = res;
              return res;    
    }
    public int tilingRectangle(int n, int m) {
          int l = Math.max(n,m);
          int s = Math.min(n, m);
        //memo
          int[][] memo = new int[s+1][l+1];
          return calcHelper(s, l, memo); //short, long   
    }
}
