Q:- https://leetcode.com/problems/odd-even-linked-list/

Ans:-
  public class Solution {
    public ListNode OddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode even = head.next, odd = head;
        ListNode startEven = head.next;
        while(even != null && even.next != null)
        {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = startEven;
        return head;
    }
}
