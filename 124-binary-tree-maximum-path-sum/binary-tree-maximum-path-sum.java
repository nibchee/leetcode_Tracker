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
    int maxPathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        pathSum(root);
        return maxPathSum;
    }
     
     private int pathSum(TreeNode root){
        if(root==null)
        return 0;

        int leftPathSum=pathSum(root.left);
        int rightPathSum=pathSum(root.right);
        if(leftPathSum<0)leftPathSum=0;
        if(rightPathSum<0)rightPathSum=0;
        //calculation Max Path Sum
        maxPathSum=Math.max(maxPathSum,leftPathSum+root.val+rightPathSum);
        
        return root.val+Math.max(leftPathSum,rightPathSum);
     }
}