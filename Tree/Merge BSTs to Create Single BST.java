Q:- https://leetcode.com/problems/merge-bsts-to-create-single-bst/
T.C:- O(n)
S.C:- O(n)

==============================================================================================
  class Solution {
    int opNumberOfNodes = 0;
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> root = new HashMap<>();
        Map<Integer,TreeNode> child = new HashMap<>();
        int numberOfNode = 0;
        for(int i = 0; i < trees.size() ; i++)
        {
            root.put(trees.get(i).val,trees.get(i));
            numberOfNode++;

            if(trees.get(i).left != null)
            {
                child.put(trees.get(i).left.val, trees.get(i).left);
                numberOfNode++;
            }

            if(trees.get(i).right != null)
            {
                child.put(trees.get(i).right.val, trees.get(i).right);
                numberOfNode++;
            }
        }
        TreeNode node = null;
        for(int i = 0 ; i < trees.size(); i++)
        {
            if(child.containsKey(trees.get(i).val))
            {
                numberOfNode--;
                TreeNode first = child.get(trees.get(i).val);
                first.left = trees.get(i).left;
                first.right = trees.get(i).right;
            }
            else
            {
                if(node == null)
                {
                    node = trees.get(i);
                }
                else
                {
                    return null;
                }
            }
        }
        return (isValid(node, Integer.MIN_VALUE, Integer.MAX_VALUE) && numberOfNode == opNumberOfNodes) ? node : null;
    }
    boolean isValid(TreeNode root,int min, int max)
    {
        if(root == null)return true;

        opNumberOfNodes++;
        if((root.val <= min || root.val >= max))return false;

        return (isValid(root.left,min,root.val) && isValid(root.right,root.val,max));
    }
}
