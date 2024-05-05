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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode() ,curr=head;
          while(curr!=null){
            ListNode temp=curr.next;
            ListNode prev=dummy;
            ListNode next=dummy.next;
            while(next!=null){
                if(next.val>curr.val)
                break;
                prev=next;
                next=next.next;
            }
          
          curr.next=next;
          prev.next=curr;
          curr=temp;
          }
        return dummy.next;
    }
}