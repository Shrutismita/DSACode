Q: - https://leetcode.com/problems/middle-of-the-linked-list/description/
TC: - O(n)
Ans:-

  
public class Solution {
    public ListNode MiddleNode(ListNode head) {
        
        ListNode slow = head, fast = head;
        while( slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }        
            return slow;      
    }
}
