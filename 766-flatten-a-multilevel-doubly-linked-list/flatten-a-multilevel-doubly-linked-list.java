/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node[] ans=flat(head);
        return ans[0];
    }

    private Node[] flat(Node head) {
        Node curr = head, prev = null;
        Node ans[] = new Node[2];
        ans[0] = curr;
        while (curr != null) {
            if (curr.child != null) {
                Node[] headTail = flat(curr.child);
                if(curr.next!=null){
                curr.next.prev=headTail[1];
                }
                headTail[1].next = curr.next;
                curr.next = headTail[0];
                headTail[0].prev=curr;
                curr.child=null;
                curr = headTail[1];
            }
            prev = curr;
            curr = curr.next;
        }
        ans[1] = prev;
        return ans;
    }
}