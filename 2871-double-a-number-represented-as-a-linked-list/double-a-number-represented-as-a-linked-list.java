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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack=new Stack<>();

        ListNode curr=head;
        while(curr!=null){
            stack.push(curr);
            curr=curr.next;
        }

        int carry=0;
        ListNode newHead=null;
        while(!stack.isEmpty()){
            ListNode node=stack.pop();
            int val=node.val;
            val=2*val+carry;
            carry=val/10;
            val=val%10;
            node.val=val;
            if(newHead==null){
            newHead=node;
            newHead.next=null;
            }
            else{
                node.next=newHead;
                newHead=node;                
            }
        }
        if(carry==1){
            ListNode newNode=new ListNode(1);
            newNode.next=newHead;
            newHead=newNode;
        }
        return newHead;
    }
}