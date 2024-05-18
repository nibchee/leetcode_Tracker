/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDia;
    }

    private int helper(TreeNode root){
        if(root==null)
        return 0;
        int leftH=(root.left!=null)?helper(root.left):0;
        int rightH=(root.right!=null)?helper(root.right):0;

        maxDia=Math.max(maxDia,leftH+rightH);

        return 1+Math.max(leftH,rightH);
    }
}