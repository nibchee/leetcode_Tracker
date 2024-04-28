/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        // moving fast to n nodes ahead of slow
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // here fast can be null or not null
        // if n==list.length then fast==null
        if (fast == null) {
            // change head
            head = slow.next;
            return head;
        }

        // move both unless fast.next is not null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        
            slow.next = slow.next.next;
        
        return head;
    }
}