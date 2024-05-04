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
    public int findLen(ListNode head){
        int c=0;
        while(head!=null){
            head=head.next;
            c++;
        }
        return c;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
        return head;
     int len=findLen(head);
     k=k%len;
      ListNode dummy=new ListNode();
      dummy.next=head;
    
      ListNode slow=head;
      ListNode fast=head;
      for(int i=0;i<k;i++)
      fast=fast.next;

      while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
      }   

      fast.next=dummy.next;
      dummy.next=slow.next;
      slow.next=null;
      return dummy.next;
    }
}