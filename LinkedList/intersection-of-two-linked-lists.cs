Q:- https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Ans:
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
         while(a != b)
         {
            a = (a == null) ? a = headB : a = a.next;
            b = (b == null) ? b = headA : b = b.next;
         }
         return a;
    }
}
