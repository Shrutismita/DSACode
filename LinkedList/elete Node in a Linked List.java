Q:- https://leetcode.com/problems/delete-node-in-a-linked-list/
      Company Tags                 : Apple, Adobe, Microsoft, Samsung
************************************************************************************************************
//T.C : O(n)
//S.C : O(1)
-----------------------------------------    
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node != null && node.next != null)
        {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        if (node != null) {
            if (prev != null)
                prev.next = null;
            else
                node = null;
        }
    }
}
