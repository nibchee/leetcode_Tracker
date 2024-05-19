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
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        boolean nullNode=false;
        while(!q.isEmpty()){
            TreeNode node=q.removeFirst();
            if(node==null)
            nullNode=true;
            else{
                if(nullNode) return false;
                q.addLast(node.left);
                q.addLast(node.right);
            }
        }
     return true;
    }
}