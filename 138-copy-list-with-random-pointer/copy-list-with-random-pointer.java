/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> clone=new HashMap<>();
        Node p=head;
        while(p!=null){
            clone.put(p, new Node(p.val));
            p=p.next;
        }

        Node p1=clone.get(head);
        Node k=p1;
         p=head;
        while(p!=null){
            p1.next=clone.get(p.next);
            p1.random=clone.get(p.random);
            p=p.next;
            p1=p1.next;
        }
    return k;
    }
}