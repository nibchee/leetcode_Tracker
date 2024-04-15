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
    int sum=0;
    int final_sum=0;
    public int sumNumbers(TreeNode root) {
        int n=root.val;
        sum=sum*10+n;
        if(root.left!=null)
        {
        sumNumbers(root.left);
            sum=sum/10;
        }
        if(root.right!=null)
        {
            sumNumbers(root.right);
           sum=sum/10;
        }
          if(root.left==null && root.right==null)
            final_sum+=sum;
          
      
        return final_sum;
    }
}