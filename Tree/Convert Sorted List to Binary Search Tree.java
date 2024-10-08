Q:- https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

T.C:- O(nlogn)
S.C:- O(logn)

=============================================Using Fast-Slow Approach=================================
  class Solution {
    public TreeNode sortedListToBST(ListNode head) {
         if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode slow_prev = null;
        while(fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        TreeNode root = new TreeNode(slow.val); 
        slow_prev.next = null; 
        root.left  = sortedListToBST(head);       
        root.right = sortedListToBST(slow.next); 
        
        return root; 
       
    }
}
