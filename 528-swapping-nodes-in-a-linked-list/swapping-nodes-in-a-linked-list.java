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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        int count=1;
        while(count<k){
            fast=fast.next;
            count++;
        }
        //storing kth from start
        ListNode temp=fast;
        ListNode slow=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        //now reached
        int v=slow.val;
        slow.val=temp.val;
        temp.val=v;
return head;
    }
}