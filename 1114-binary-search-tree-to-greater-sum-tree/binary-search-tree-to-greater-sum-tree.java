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
    ArrayList<TreeNode> inorder; 
    public TreeNode bstToGst(TreeNode root) {
      inorder=new ArrayList<>();
        inorder(root);
        int sum=0;
        for(int i=inorder.size()-1;i>=0;i--){
         sum+=inorder.get(i).val;
         TreeNode current=inorder.get(i);
         current.val=sum;
        }
        return root;
    }

    private void inorder(TreeNode root){
      if(root==null) return;
      inorder(root.left);
      inorder.add(root);
      inorder(root.right);
    }
}