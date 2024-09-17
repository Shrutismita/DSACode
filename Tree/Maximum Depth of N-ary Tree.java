Q:- https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

T.C:- O(n)
S.C:- O(1)

  ==============================================================
  class Solution {
    int max = 0 ;
    void solve(Node root,int n)
    {
        if(root == null)return ;
        max = Math.max(max,n);
        if(root.children == null)return ;
        for(Node c : root.children)
        {
            solve(c, n + 1);
        }
    }
    public int maxDepth(Node root) {
        solve(root,1);
        return max;
    }
}
