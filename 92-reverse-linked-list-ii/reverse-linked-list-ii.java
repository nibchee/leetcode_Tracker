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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      if(head==null)
      return null;

      if(head.next==null || left==right)
      return head;

      ListNode leftPos=null,rightPos=null;

      ListNode curr=head;
      int count=1;
      
      while(curr!=null && count<=right){
        if(count==left-1){
          leftPos=curr;
        }
        if(count==right){
            rightPos=curr;
        }
        curr=curr.next;
        count++;
      }
      ListNode rightPos2=rightPos;
      rightPos=rightPos.next;
      rightPos2.next=null;
      ListNode [] headTail=null;
      if(left==1)
     headTail=reverseLL(head);
     else
     headTail=reverseLL(leftPos.next);

      if(left==1)
      head=headTail[0];
      else
      leftPos.next=headTail[0];
      headTail[1].next=rightPos;
      
   
      return head;  
    }

    private ListNode[] reverseLL(ListNode head){
        ListNode[] headTail=new ListNode[2];
        headTail[1]=head;
        ListNode curr=head,prev=null,next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
       headTail[0]=prev;
       return headTail;
    }
}