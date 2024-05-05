/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public void process(Stack<Pair> st) {
        Pair curr = st.peek();
        if (curr.state == 1) {
            curr.state++;
            if (curr.node.left != null)
                st.push(new Pair(curr.node.left, 1));
        } else if (curr.state == 2) {
            curr.state++;
            if (curr.node.right != null) {
                st.push(new Pair(curr.node.right, 1));
            }
        } else {// state 3
            st.pop();
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<Pair> st1 = new Stack<>();
        Stack<Pair> st2 = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
        if (root1 != null)
            st1.push(new Pair(root1, 1));
        if (root2 != null)
            st2.push(new Pair(root2, 1));

        while (st1.size() > 0 || st2.size() > 0) {
            while (!st1.isEmpty() && st1.peek().state != 2)
                process(st1);
            while (!st2.isEmpty() && st2.peek().state != 2)
                process(st2);

            if (!st1.isEmpty() && (st2.isEmpty() || st1.peek().node.val < st2.peek().node.val)) {
                inorder.add(st1.peek().node.val);
                process(st1);
            } else if(!st2.isEmpty()){
                inorder.add(st2.peek().node.val);
                process(st2);
            }
        }
        return inorder;
    }
}