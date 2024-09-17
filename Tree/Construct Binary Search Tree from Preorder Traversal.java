Q:- https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
T.C:- O(n)
S.C:- O(1)

====================================================================================================
  class Solution {
    TreeNode solve(int[] preorder, int i, int j)
    {
        if(i > j)return null;
        int val = preorder[i];
        int index = i;
        while(index <= j && preorder[index] <= val)
        {
            index++;
        }
        TreeNode root = new TreeNode(val);
        root.left = solve(preorder, i+1, index-1);
        root.right = solve(preorder, index, j);

        return root;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
       return solve(preorder , 0,preorder.length - 1);
       
    }
}
