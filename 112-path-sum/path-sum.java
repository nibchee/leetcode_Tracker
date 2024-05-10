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
    boolean ans=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root,0,targetSum);
        return ans;
    }

    public void helper(TreeNode root,int sumSoFar,int target){
    if(root==null)
    return ;
    int newSum=sumSoFar+root.val;
    if(root.left==null && root.right==null){
        if(newSum==target){
            ans=true;
        }
        return;
    }
    helper(root.left,newSum,target);
    helper(root.right,newSum,target);
  }
}