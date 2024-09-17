Q:- https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  class Solution {
    int idx = 0;
        boolean solve(TreeNode root, int[] voyage, List<Integer> ans)
        {
        if(root == null) return true;
        
        if(root.val != voyage[idx]) return false;
        
        int temp = idx++;
        boolean res = solve(root.left, voyage, ans) && solve(root.right, voyage, ans);
        
        if(res == false){
            idx = ++temp;

            res = solve(root.right, voyage,  ans) && solve(root.left, voyage, ans); 
            if(res == true)
               ans.add(root.val);
        }

        return res;
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        boolean match = solve(root, voyage, ans);
        if(match != false) return ans;
        else return Arrays.asList(-1);
    }
}
