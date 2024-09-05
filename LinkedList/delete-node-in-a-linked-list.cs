Q:- https://leetcode.com/problems/delete-node-in-a-linked-list/
TC - O(n)
Ans:
public class Solution {
    public void DeleteNode(ListNode node) {
        ListNode prev = null;
        while(node != null && node.next != null)
        {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
        
    }
}
