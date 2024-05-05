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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(), curr = head;
        while (curr != null) {
            // saving next pos of curr in temp
            ListNode temp = curr.next;
            ListNode prev = dummy;
            ListNode next = dummy.next;
            // Unless Find correct pos, keep sliding ptrs
            while (next != null && next.val < curr.val) {
                prev = next;
                next = next.next;
            }
            // Setting the current Node
            prev.next = curr;
            curr.next = next;
            curr = temp;
        }
        return dummy.next;
    }
}