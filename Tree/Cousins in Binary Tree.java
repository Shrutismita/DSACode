Q:- https://leetcode.com/problems/cousins-in-binary-tree/
T.C:- O(n)
S.C:- O(n)
  ==============================================================
  
class Solution {
    TreeNode xParent, yParent ;
    int xDepth = -1, yDepth = -1;
    void dfs(TreeNode currNode, TreeNode parent, int x,int y,int depth)
    {
        if(currNode == null)return;
        if(currNode.val == x)
        {
            xDepth = depth;
            xParent = parent;
            return;
        }
        else if(currNode.val == y)
        {
            yDepth = depth;
            yParent = parent;
            return;
        }
        dfs(currNode.left, currNode, x, y,depth + 1);
        dfs(currNode.right, currNode, x, y,depth+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return xParent != yParent && xDepth == yDepth;
    }
}

  
