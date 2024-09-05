Q: https://leetcode.com/problems/linked-list-cycle-ii/description/
TC :- O(n)
Ans:

public class Solution {
    public ListNode DetectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast=head;
        ListNode ptr = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
             break;
         
        }
        if(slow != fast) return null;

         while(ptr != slow)
         {
            ptr = ptr.next;
            slow = slow.next;            
         }
          return ptr;
    }
}
