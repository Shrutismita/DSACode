Q:- https://leetcode.com/problems/unique-binary-search-trees-ii/

T.C:- O(n*m)
S.C:- O(n)

=====================================================================
  class Solution {
    Map<Pair<Integer,Integer>, List<TreeNode>> memo;
       List<TreeNode> allPossibleBST(int start, int end)
       {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (memo.containsKey(new Pair<>(start, end))) {
            return memo.get(new Pair<>(start, end));
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1);
            List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end);

            for (TreeNode left: leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(start, end), res);
        return res;
    }
       
    public List<TreeNode> generateTrees(int n) {
        memo = new HashMap<>();
        return allPossibleBST(1, n);
    }
}
