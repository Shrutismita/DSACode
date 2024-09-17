Q:- https://leetcode.com/problems/kth-smallest-element-in-a-bst/

T.C:- O(n)
S.C:- O(n)

================================================================================
  
class Solution {
    int count = 0;
    void inOrder(TreeNode root, int k,int[] ans)
    {
        if(root == null)return ;

        inOrder(root.left,k,ans);
        count++;
        if( k == count)
        {
            ans[0] = root.val;
            return ;
        }
        inOrder(root.right,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        inOrder(root,k,ans);
        return ans[0];
    }
}
