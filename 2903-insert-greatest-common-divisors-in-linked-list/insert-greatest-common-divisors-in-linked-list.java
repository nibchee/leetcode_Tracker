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
  private  int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode ptr=head;
        while(ptr!=null && ptr.next!=null){
            int d1=ptr.val;
            int d2=ptr.next.val;
            int d3=gcd(d1,d2);
            ListNode newNode=new ListNode(d3);
            newNode.next=ptr.next;
             ptr.next=newNode;
             ptr=ptr.next.next;
        }
    return head;
    }
}