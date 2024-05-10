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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans=0;
        helper(root,0);
        return ans;
    }
  public void helper(TreeNode root,int numSoFar){
    if(root==null)
    return ;
    int newNumber=numSoFar*10+root.val;
    if(root.left==null && root.right==null){
        ans+=newNumber;
        return;
    }
    helper(root.left,newNumber);
    helper(root.right,newNumber);
  }
}
