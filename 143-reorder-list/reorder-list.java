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
    public void reorderList(ListNode head) {
        // if length is 1
        if (head.next == null)
            return;

        // Find Mid such that index n/2 always for even/odd both
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at n/2 idx
        ListNode temp = slow.next;
        // breaking list at mid
        slow.next = null;

        // Storing all reference in stack , as here we need Ln-1,Ln-2..
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Now Iterating first half & adding nodes in it
        ListNode curr = head;
        while (curr != null) {
            // as for Odd list for last node stack is empty
            if (!stack.isEmpty()) {
                ListNode node = stack.pop();
                node.next = curr.next;
                curr.next = node;
            }
            // moving curr by 2 positions as adding node after current
            curr = curr.next != null ? curr.next.next : curr.next;
        }

    }
}