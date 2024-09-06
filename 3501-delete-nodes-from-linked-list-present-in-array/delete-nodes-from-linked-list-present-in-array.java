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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null)
        return head;
        
        HashSet<Integer> s=new HashSet<>();
        for(int num:nums){
          s.add(num);
        }

        
        while(head!=null && s.contains(head.val)){
          head=head.next;
        }

        ListNode ptr=head;

        while(ptr!=null){
          if(ptr.next!=null && s.contains(ptr.next.val)){
                ptr.next=ptr.next.next;
          }else{
            ptr=ptr.next;
          }
         }
   return head;
    }

}