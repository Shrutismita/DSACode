Q:- https://leetcode.com/problems/reverse-linked-list/description/
Write the code using Recursion approach
Ans:

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)
        {
           return head;
        }

        ListNode last =  ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
        
    }
}
