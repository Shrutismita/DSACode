Q:- https://leetcode.com/problems/serialize-and-deserialize-bst/
T.C:- O(n)
S.C:- O(n)
 ===============================================================================
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while(queue.size() > 0)
        {
            TreeNode node = queue.poll();
            if(node != null)
            {
                queue.add(node.left);
                queue.add(node.right);
                sb.append(node.val);
                sb.append(',');
            }
            else
            {
                sb.append('#');
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(0) == '#')return null;
        Queue<TreeNode> que = new LinkedList<>();
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        que.add(root);
        int n = str.length;
        int i = 1;
        while(i < n)
        {
            TreeNode node = que.poll();
            if(!str[i].equals("#"))
            {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                que.add(node.left);
            }
            if(!str[i + 1].equals("#"))
            {
                node.right = new TreeNode (Integer.parseInt(str[i+1]));
                que.add(node.right);
            }
            i += 2;
        }
        return root;
    }
}

