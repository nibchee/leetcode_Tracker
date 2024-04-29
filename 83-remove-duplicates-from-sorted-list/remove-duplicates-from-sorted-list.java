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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr=head;
        while(ptr!=null && ptr.next!=null){
            ListNode check=ptr;
            while(check!=null && ptr.val==check.val){
              check=check.next; 
            }
            ptr.next=check;
            ptr=ptr.next;
        }
        return head;
    }
}