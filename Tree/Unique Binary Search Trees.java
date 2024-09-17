Q:- https://leetcode.com/problems/unique-binary-search-trees/

T.C:- O(n)
S.C:- O(1)

=====================================================================================  
  class Solution {
    int bstTree(int start, int end)
    {
        if(start >= end)return 1;
        int total = 0;
        for(int i = start; i <= end; i++)
        total += bstTree(start, i -1) * bstTree(i+1, end);
        return total;
    }
    public int numTrees(int n) {
        return bstTree(1,n);
    }
}
