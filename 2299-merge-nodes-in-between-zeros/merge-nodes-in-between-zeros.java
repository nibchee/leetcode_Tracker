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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head;
        ListNode ans=head;
        while(curr!=null){
          if(curr.val==0){
            curr=curr.next;
            ans.next=curr;
          }
          int val=0;
          while(curr!=null && curr.val!=0){
            val+=curr.val;
            curr=curr.next;
          }
          ans=ans.next;
          if(ans!=null)ans.val=val;
          
        }
    return head.next;
    }
}