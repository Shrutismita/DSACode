Q:- https://leetcode.com/problems/palindrome-linked-list/description/

Ans:
public class Solution {
     ListNode curr;
    public bool IsPalindrome(ListNode head) {
         curr = head;
        return Recursion(head);
    }
    public bool Recursion(ListNode head)
    {
        if(head == null) return true;
         bool isPalindrome = Recursion(head.next);
         if(curr.val != head.val)
         {
            return false;
         }
         curr = curr.next;
         return isPalindrome;
    }
}
