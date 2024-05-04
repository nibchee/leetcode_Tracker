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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right)
            return head;

        int count = 1;
        ListNode l = null, r = null, prev = null, curr = head;
        ListNode LNull = null;

        ListNode next = (curr.next != null) ? curr.next : null;

        while (curr != null && count <= right) {
            if (count == left) {
                l = prev;
                if (l == null) {
                    LNull = curr;
                }
            }

            if (count == right) {
                r = next;
            }

            if (count >= left && count <= right) {
                // reverse link
                curr.next = prev;
            }
            // Slide Pointer
            prev = curr;
            curr = next;
            next = next != null ? next.next : null;

            count++;
        }
        if (l == null ) {
            if (r!= null)
                LNull.next = r;
            head = prev;
        } else {
            l.next.next = r;
            l.next = prev;
        }
        return head;
    }
}