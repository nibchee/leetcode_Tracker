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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int si,int ei){
        if(si>ei) return null;
        int mi=(si+ei)/2;
        TreeNode curr=new TreeNode(nums[mi]);
        curr.left=sortedArrayToBST(nums,si,mi-1);
        curr.right=sortedArrayToBST(nums,mi+1,ei);
        return curr;
    }
}