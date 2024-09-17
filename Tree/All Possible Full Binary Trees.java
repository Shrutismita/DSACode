Q:- https://leetcode.com/problems/all-possible-full-binary-trees/
T.C:- O(n)
S.C:- O(1)

 ==================================================================================
  class Solution {
    List<TreeNode> solve (int n)
    {
        ArrayList<TreeNode> list=new ArrayList<>();
        if(n==1){
            TreeNode node=new TreeNode(0);
            list.add(node);
            return list;
        }
        if(n%2==0){
            return list;
        }

      
        for(int i=1; i<n; i=i+2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node=new TreeNode(0);
                    node.left=l;
                    node.right=r;
                    list.add(node);
                }
            }
        }

        return list;
    }
    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
