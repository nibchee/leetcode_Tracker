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
    String ans = "";

    public String tree2str(TreeNode root) {
        preOrder(root);
        return ans;
    }

    private void preOrder(TreeNode root) {
        Integer val = root.val;
        ans += val.toString();
        if (root.left == null && root.right == null)
            return;
        ans += "(";
        if (root.left != null)
            preOrder(root.left);
        ans += ")";
        if (root.right != null) {
            ans += "(";
            preOrder(root.right);
            ans += ")";
        }

    }
}