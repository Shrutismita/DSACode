Q:- https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

T.C:- O(n*m^2) --Where m is the number of leaf node
S.C:- O(n*m)
==============================================================================================
  
class Solution {
    List<Integer> solve (TreeNode root, int distance, int[] goodLeafNodes)
    {
        if(root == null)
        {
            List<Integer> emptyList = new ArrayList<>();
            emptyList.add(0);
            return emptyList;
        }
        if(root.left == null && root.right == null)
        {
            List<Integer> singleList = new ArrayList<>();
            singleList.add(1);
            return singleList;
        }
        List<Integer> leftDistances = solve(root.left, distance, goodLeafNodes);
        List<Integer> rightDistances = solve(root.right, distance, goodLeafNodes);

        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l != 0 && r != 0 && l + r <= distance) {
                    goodLeafNodes[0]++;
                }
            }
        }
         List<Integer> currentDistances = new ArrayList<>();
        for (int ld : leftDistances) {
            if (ld != 0 && ld + 1 <= distance) {
                currentDistances.add(ld + 1);
            }
        }

        for (int rd : rightDistances) {
            if (rd != 0 && rd + 1 <= distance) {
                currentDistances.add(rd + 1);
            }
        }

        return currentDistances;
    }
    public int countPairs(TreeNode root, int distance) {
        int[] goodLeafNodes = new int[1];
        solve(root, distance, goodLeafNodes);
        return goodLeafNodes[0];
    }
}
  