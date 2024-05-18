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
    int minD=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
        return 0;
        helper(root,0);
        return minD;
    }

    public void helper(TreeNode root,int level){
         if(root==null)
         return;
         if(root.left==null && root.right==null)
         minD=Math.min(minD,level+1);

         if(root.left!=null)
         helper(root.left,level+1);

         if(root.right!=null)
         helper(root.right,level+1);

    }
}