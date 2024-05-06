/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
           if (head == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // reaching at middle at n/2th Node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now reached middle store slow.next in new head
        ListNode newHead = slow.next;
        // break list
        slow.next = null;

        // Reverse 2nd part
        ListNode curr = newHead;
        ListNode prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        newHead = prev;
        int sum=0;
        // Iterate both & keep finding Max Sum of twins
        ListNode curr1 = head, curr2 = newHead;
        while (curr1 != null && curr2 != null) {
            // System.out.println(curr1.val +" "+curr2.val);
            sum=Math.max(sum,curr1.val+curr2.val);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return sum;  
    }
}