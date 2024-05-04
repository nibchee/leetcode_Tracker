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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode prev=null;
        ListNode curr=head;
       while(curr!=null){
        if(curr.next!=null && curr.val==curr.next.val){
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
            }
        }else{
            if(prev==null){
                prev=curr;
                head=prev;
            }else{
            prev.next=curr;
            prev=prev.next;
            }
        }
        curr=curr.next;
       }
       if(prev==null) head=null;
       else
     {
         prev.next=null;
     }
           return head;
    }
}
