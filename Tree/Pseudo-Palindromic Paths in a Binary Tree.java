Q:- https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
T.C:- O(n)
S.C:- O(1)

===============================================================================================
  class Solution {
    int result = 0;
    void solve (TreeNode root, int[] temp)
    {
        if(root != null)
        {
            temp[root.val]++;
            if(root.left == null && root.right == null)
            {
                int oddFreq = 0;
                for(int i = 1; i <= 9;i++)
                {
                    if(temp[i]%2 != 0)
                    {
                        oddFreq++;
                    }
                }
                result += oddFreq <= 1 ? 1:0;
            }
            solve(root.left,temp);
            solve(root.right,temp);
            temp[root.val]--;
        }
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] temp = new int[10];
        solve(root,temp);
        return result;
    }
}
