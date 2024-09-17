Q:- https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

T.C:- O(n)
S.C:- O(n)

=========================================================================================
  class Solution {
   
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
         ArrayList<Integer> res=new ArrayList<>();
    inorder(root1,res);
    inorder(root2,res);
    Collections.sort(res);
    return res;
    }
    static void inorder(TreeNode root,ArrayList<Integer> res)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
