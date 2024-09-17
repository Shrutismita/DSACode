Q:- https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
T.C:- O(n)
S.C:- O(n)
  ==========================================================================
  public class Codec {
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
               String res = "";
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res = res + "n ";
            } else {
                res = res + node.val + " ";
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        return res;
      
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        
        for(int i = 1; i < nodeValues.length; i++) {
            TreeNode parentNode = queue.poll();
            if (!nodeValues[i].equals("n")) {
                parentNode.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.left);
            }
            if (!nodeValues[++i].equals("n")) {
                parentNode.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.add(parentNode.right);
            }
        }
        return node;
    }
}

