Q:- https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
TC :- O(n)
Ans:
public class Solution {
    public ListNode DeleteMiddle(ListNode head) {
        if(head == null || head.next == null)
        {
            return null;
        }
        ListNode prev = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        
        return head;
    }
}
