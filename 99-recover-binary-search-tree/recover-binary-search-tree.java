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
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    TreeNode first,issue, second;

    public void swap(TreeNode a,TreeNode b){
      int temp=a.val;
      a.val=b.val;
      b.val=temp;
    }

    public void recoverTree(TreeNode root) {
       inOrder(root);
       if(second==null){
        swap(first,issue);
       }else{
        swap(first,second);
       }
    }

    public void inOrder(TreeNode root){
 if(root==null) return;
        inOrder(root.left);
        //process yourself
        if(prev!=null && prev.val>root.val){
            //validation
            if(first==null){
                       issue=root;
                       first=prev;
            }else{
                //second validation
                second=root;
            }
        }
        prev=root;
        inOrder(root.right);
    }
}