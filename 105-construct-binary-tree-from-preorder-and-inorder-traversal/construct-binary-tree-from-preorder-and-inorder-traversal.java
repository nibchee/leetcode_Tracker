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
    int pi=0;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     map=new HashMap<>();
     for(int i=0;i<inorder.length;i++)
     map.put(inorder[i],i);
     return buildTree(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int[] inorder,int si,int ei){
          if(si>ei) return null;
        TreeNode curr=new TreeNode(preorder[pi]);
        int idx=map.get(preorder[pi]);
        pi++;
        if(si==ei) return curr;
        curr.left=buildTree(preorder,inorder,si,idx-1);
        curr.right=buildTree(preorder,inorder,idx+1,ei);
        return curr;
    }


}