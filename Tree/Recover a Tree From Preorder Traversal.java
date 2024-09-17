Q:- https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
T.C:- O(n)
S.C:- O(n)

================================================================================================
  
class Solution {
    int i = 0;
    TreeNode preOrder(String str, int depth)
    {
        int d = 0;
        while(i+d < str.length() && str.charAt(i+d) == '-')
        d++;
        if(d != depth)
        return null;
        int nd = 0;
        while(i+d+nd < str.length() && str.charAt(i+d+nd) != '-')
        nd++;
        int val = Integer.parseInt(str.substring(i+d,i+d+nd));
        i = i+d+nd;
        TreeNode node = new TreeNode(val);
        node.left = preOrder(str,depth+1);
        node.right = preOrder(str,depth+1);

        return node;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        return preOrder(traversal,0);
    }
}
