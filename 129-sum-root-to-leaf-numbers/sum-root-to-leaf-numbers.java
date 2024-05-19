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
    private void sumOfPaths(TreeNode root, int nsf){
        nsf=nsf*10+root.val;
        if(root.left==null && root.right==null)
        sum+=nsf;

        if(root.left!=null)
        sumOfPaths(root.left,nsf);

        if(root.right!=null)
        sumOfPaths(root.right,nsf);
        
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sumOfPaths(root,0);
        return sum;
    }
}