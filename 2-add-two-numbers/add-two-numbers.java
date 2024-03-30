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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
             int carry=0;
             int sum=l1.val+l2.val+carry;
             
             ListNode l3,start;
             start=new ListNode();
             start.val=sum%10;
             start.next=null;
             carry=sum/10;

             l3=start;

             l1=l1.next;
             l2=l2.next;

             while(l1!=null && l2!=null){
                 ListNode newNode=new ListNode();
                 sum=l1.val+l2.val+carry;
                  newNode.val=sum%10;
                newNode.next=null;
                   carry=sum/10;

                   l3.next=newNode;
                   l3=newNode;

                   l1=l1.next;
                   l2=l2.next;
}

while(l1!=null)
    {
        ListNode newNode=new ListNode();
               sum=l1.val+carry;
                newNode.val=sum%10;
                carry=sum/10;
                newNode.next=null;
                   l3.next=newNode;
                   l3=newNode;

                   l1=l1.next;
                  
    }

    while(l2!=null)
    {
        ListNode newNode=new ListNode();
                  sum=l2.val+carry;
                newNode.val=sum%10;
                carry=sum/10;
                newNode.next=null;
                   l3.next=newNode;
                   l3=newNode;

                   l2=l2.next;
                  
    }

    if(carry!=0){
        ListNode newNode=new ListNode();
       newNode.val=carry;
                carry=0;
                newNode.next=null;
       l3.next=newNode;
                   l3=newNode;
    }

return start;
           }
}